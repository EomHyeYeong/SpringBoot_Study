package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 클래스 안쪽의 모든 필드를 매개변수로 하는 생성자 자동으로 생성
@ToString           // toString() 메서드 간소화
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
