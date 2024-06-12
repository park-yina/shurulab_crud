package com.example.entity;

import com.example.board.BoardType;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

@Entity
@Table(name="noticeBoard")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private BoardType boardType;
	private String description;

	@OneToMany()
	private List<PostEntity> posts;
}