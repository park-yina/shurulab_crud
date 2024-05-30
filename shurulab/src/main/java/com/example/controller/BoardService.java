package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.board.BoardType;

public class BoardService {
	    private PostRepository postRepository;

    public List<PostEntity> getPostsByBoardType(BoardType boardType) {
        return postRepository.findByBoardBoardType(boardType);
    }
}
