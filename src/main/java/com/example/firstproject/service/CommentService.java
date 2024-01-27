package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        // 1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // 2. 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();    // DTO 목록으로 변환히기 위해 빈 ArrayList 생성

        for (int i = 0; i < comments.size(); i++) {             // 비어있는 dtos에 DTO를 담기
            Comment c = comments.get(i);                        // 엔티티를 하나씩 꺼내기
            CommentDto dto = CommentDto.createCommentDto(c);    // 엔티티를 DTO로 변환
            dtos.add(dto);
        }

        // 3. 결과 반환
        return dtos;
    }
}
