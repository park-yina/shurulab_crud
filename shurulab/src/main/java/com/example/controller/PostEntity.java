package com.example.controller;

import com.example.board.BoardType;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @Column(length=100000)
    private String content;
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(length=300000)
    private byte[] photo;
    @Column(columnDefinition = "integer default 0")
    private Long views=0L;
    private String boardType;
    private String author;
}
