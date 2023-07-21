package com.jong.blog.dto;

import com.jong.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 값을 파라미터로 받음
@Getter // Getter 함수 구현 어노테이션
// 컨트롤러의 요청을 받아낼 dto
public class AddArticleRequest {

    private String title;
    private String content;

    // 객체 생성부
    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }
}
