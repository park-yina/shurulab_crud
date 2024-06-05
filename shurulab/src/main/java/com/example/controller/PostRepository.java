package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.board.BoardType;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

	List<PostEntity> findByBoardType(String boardType);
}
