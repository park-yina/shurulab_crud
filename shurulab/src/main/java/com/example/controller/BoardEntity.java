package com.example.controller;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.example.board.BoardType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name="noticeBoard")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  @Id
	    @Enumerated(EnumType.STRING)
	    private BoardType boardType;
	    private String description;

	    @OneToMany(mappedBy = "board")
	    private List<PostEntity> posts;
}
