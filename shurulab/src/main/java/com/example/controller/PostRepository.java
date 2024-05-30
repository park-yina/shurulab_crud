package com.example.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.BoardType;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByBoardBoardType(BoardType boardType);

}
