package com.example.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private String author;
	private Long views;	
	private String title;
	private BoardType boardType; //노가다로 하기보다는 어차피 경우의 수 몇개 안되니까 enum에 알파벳을 넣었습니다.

}
