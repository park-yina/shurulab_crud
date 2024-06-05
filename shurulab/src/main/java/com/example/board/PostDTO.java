package com.example.board;


import org.springframework.beans.BeanUtils;

import com.example.controller.PostEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostDTO {
    private String title;
    private String content;
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(length=300000)
    private byte[] photo;
    
    @Column(nullable = false)
    private String author;
    
    private String boardType;
    public static PostDTO toPostDTO(PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(postEntity, postDTO);
        postDTO.setBoardType(postEntity.getBoardType().toString()); // 열거형을 문자열로 변환
        return postDTO;
    }
    @Column(columnDefinition = "integer default 0", nullable = false)
    private Long views;

}
