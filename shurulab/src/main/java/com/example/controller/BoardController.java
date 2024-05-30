package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.BoardDTO;
import com.example.board.BoardType;
import com.example.dto.UserCreateDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	@GetMapping("")
	public String board(Model model){
		model.addAttribute("BoardDTO", new BoardDTO());
		return "board";
	}

    @GetMapping("/a")
    public String getBoardPostA(Model model) {
    	model.addAttribute("boardType", BoardType.A);
        return "detail_board"; // 템플릿 파일의 경로 수정
    }
    @GetMapping("/b")
    public String getBoardPostB(Model model) {
    	model.addAttribute("boardType", BoardType.A);
        return "detail_board"; // 템플릿 파일의 경로 수정
    }
    @GetMapping("/c")
    public String getBoardPostC(Model model) {
    	model.addAttribute("boardType", BoardType.A);
        return "detail_board"; // 템플릿 파일의 경로 수정
    }
    @GetMapping("/d")
    public String getBoardPostD(Model model) {
    	model.addAttribute("boardType", BoardType.A);
        return "detail_board"; // 템플릿 파일의 경로 수정
    }

	
}
