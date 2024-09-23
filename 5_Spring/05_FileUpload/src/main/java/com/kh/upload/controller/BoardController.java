package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.text.Format;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/list")
	public String list(Board board, Model model, MultipartFile file, Paging paging) {
		model.addAttribute("list", service.readBoard(paging));
		return "list";
	}
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@GetMapping("/contentInfo")
	public String contentInfo() {
		return "contentInfo";
	}
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
				
		File copyFile = new File("D:\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 path 위치로 저장
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
		System.out.println("파일 이름 : "+ file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : "  + file.getName());
		fileUpload(file);
		
		return "redirect:/";
	}
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			fileUpload(file);
		}
		return "redirect:/";
	}
	@PostMapping("/write")
	public String addBoard(Board board, MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		board.setUrl(fileName);
		board.setDate(LocalDateTime.now());
		board.setFile(file);
		service.addBoard(board);
		File copyFile = new File("D:\\back-end-workspace\\5_Spring\\05_FileUpload\\src\\main\\resources\\static\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 path 위치로 저장
		
		return "redirect:/";
	}
	@ResponseBody
	@PostMapping("/contentInfo")
	public void contentInfo(String number, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int num = Integer.parseInt(number);
		Board board = service.readChooseBoard(num);
		System.out.println(board);
		session.setAttribute("content", board);
	}
	
	
}
