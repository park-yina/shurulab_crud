package com.example.repository;

import java.util.List;

import com.example.entity.BoardEntity;
import com.example.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.BoardType;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByBoardType(String boardType);
}
