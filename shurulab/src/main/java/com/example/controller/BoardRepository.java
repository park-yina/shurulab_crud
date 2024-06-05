package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.BoardType;

public interface BoardRepository extends JpaRepository<A_BoardEntity, Long> {
    static final Logger logger = LoggerFactory.getLogger(BoardRepository.class);

    A_BoardEntity findByBoardType(BoardType boardType);

}

