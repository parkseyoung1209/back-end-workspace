package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.model.vo.Subscribe;
import com.semi.youtube.model.vo.Video;
import com.semi.youtube.model.vo.VideoLike;
import com.semi.youtube.service.VideoService;


@Controller
public class PageController {
	@Autowired
	private VideoService video;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list", video.allVideo());
		return "index";
	}
	
	@GetMapping("/{videoCode}")
	public String detail(@PathVariable("videoCode") int videoCode, Model model) {
		
		Video data = video.detail(videoCode);
		
		model.addAttribute("video", data);
		model.addAttribute("list", video.allVideo());
		model.addAttribute("count", video.count(data.getChannel().getChannelCode()));
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member member = (Member) authentication.getPrincipal();
		VideoLike like = null;
		Subscribe sub = null;
		if(member!=null) {
			like = video.checkLike(VideoLike.builder()
					.id(member.getId())
					.videoCode(videoCode)
					.build());
			sub = video.check(Subscribe.builder()
					.id(member.getId())
					.channelCode(data.getChannel().getChannelCode())
					.build());
		}
		model.addAttribute("like", like);
		model.addAttribute("sub", sub);
		return "detail";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
}
