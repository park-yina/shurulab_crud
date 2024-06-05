package com.example.board;

import java.util.ArrayList;
import java.util.List;

import com.example.controller.PostEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class A_BoardDTO {
	private String author;
	private Long views;	
	private String title;
    private List<PostEntity> posts = new ArrayList<>();

}
