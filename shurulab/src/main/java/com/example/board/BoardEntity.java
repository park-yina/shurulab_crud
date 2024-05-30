package com.example.board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
	@Column(nullable=false)
	private String author;
	@Column(nullable=false)
	private String title;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private BoardType boardType; //노가다로 하기보다는 어차피 경우의 수 몇개 안되니까 enum에 알파벳을 넣었습니다.
	@Column(nullable=false)
	private String poster;
	@Column(nullable=false)
	private String content;
	@Column(nullable=false)
	private Long views;//고라니 가라사대, 어떤 미친놈들은 상식을 초월하는 짓을 한다 하셨으니
    @Lob
    private byte[] photo;
}
