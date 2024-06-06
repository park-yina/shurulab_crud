package com.example.board;


import java.time.LocalDateTime;


import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.controller.PostEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
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
        postDTO.setBoardType(postEntity.getBoardType().toString());
        return postDTO;
    }
    @Column(columnDefinition = "integer default 0", nullable = false)
    private Long views;
    
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

}
