package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/* REST(Representational State Transfer)
 * : API를 설계하는 아키텍쳐
 * 
 * 
 * RESTful : REST 원칙을 준수하는 방식
 * API(Application Programming Interface) : 서로 다른 애플리케이션들이 서로 데이터를 주고 받을 수 있게 하는 도구
 * 
 */

@RestController
@RequestMapping("/api/*") // api/v1 v2 v3.. <-단순 버전 의미
// 실제 주소가 http://localhost:8080/api
public class BoardController {
	
	private String path = "\\\\192.168.10.51\\upload\\";
	@Autowired
	private BoardService service;
	
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
				
		File copyFile = new File("D:\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 path 위치로 저장
	}
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			fileUpload(file);
		}
		return "redirect:/";
	}
	
	
	// CRUD : Create - Post, Read - Get, Update - Put, Delete - Delete
	
	
	// Create - Post
	@PostMapping("/board")
	public ResponseEntity addBoard(Board board, MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		board.setUrl(fileName);
		board.setDate(LocalDateTime.now());
		board.setFile(file);
		service.addBoard(board);
		File copyFile = new File(path + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 path 위치로 저장
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Read - Get : 전체 목록 보기
		@GetMapping("/board")
		public ResponseEntity list(Paging paging) {
			List<Board> list = service.readBoard(paging);
			
			return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, paging));
		}
		
		// read 1개만
		@GetMapping("/board/{no}")
		public ResponseEntity view(@PathVariable int no) {
			Board board = service.readChooseBoard(no);
			if(board!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(board);
			} else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	
	// update - Put
	@PutMapping("/board")
	public ResponseEntity update(Board vo) throws IllegalStateException, IOException {
		System.out.println(vo);
		System.out.println(vo.getFile().isEmpty());
		if(vo.getFile().isEmpty()) {
			// 파일이 비어있다면 기존 이미지 url 그대로 DB에 저장\
		} else {
			// 파일이 비어있지 않다면 기존 이미지 삭제, 새 이미지 등록
			File file = new File(path + vo.getUrl());
		}
		service.update(vo);
		// title, content, url, no
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	//delete - delete
	@DeleteMapping("/board/{no}")
	public ResponseEntity delete(@PathVariable int no) {
		
		// 업로드한 파일 삭제 (필요한 건 URL)
		Board board = service.readChooseBoard(no);
			if(board.getUrl()!=null) { // 기존 이미지가 null이 아닌 경우
				File file = new File(path + board.getUrl());
				file.delete();
			}
		
		service.delete(no);
		return ResponseEntity.status(HttpStatus.OK).build();
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