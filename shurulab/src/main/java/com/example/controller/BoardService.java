package com.example.controller;

import org.springframework.stereotype.Service;

import com.example.board.BoardType;
import com.example.board.PostDTO;

import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final PostRepository postRepository;

    @Autowired
    public BoardService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity createPostForABoard(String title, String content, String author, byte[] photo,String boardType) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setPhoto(photo);
        postEntity.setAuthor(author);
        postEntity.setBoardType(boardType);
        return postRepository.save(postEntity);
    }

    public List<PostDTO> findAll() {
        // 모든 게시물 엔티티를 가져옴
        List<PostEntity> postEntityList = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        // 엔티티를 DTO로 변환하여 리스트에 추가
        for(PostEntity postEntity: postEntityList){
            postDTOList.add(PostDTO.toPostDTO(postEntity));
        }
        return postDTOList;
    }
    public String findAuthorById(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id의 게시물을 찾을 수 없습니다: " + id));
        return post.getAuthor();
    }
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
    public void updatePost(Long postId, String title, String content, @Nullable byte[] photo) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("해당 id의 게시물을 찾을 수 없습니다: " + postId));

        postEntity.setTitle(title);
        postEntity.setContent(content);
        if (photo != null) {
            postEntity.setPhoto(photo);
        }
        postRepository.save(postEntity);
    }

}
