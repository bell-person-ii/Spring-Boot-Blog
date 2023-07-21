package com.jong.blog.controller;

import com.jong.blog.domain.Article;
import com.jong.blog.dto.AddArticleRequest;
import com.jong.blog.dto.ArticleResponse;
import com.jong.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle (@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request); // 요청된 데이터를 블로그 서비스를 통해 DB에 저장하고 저장한 객체를 반환해서 저장
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle); //응답코드
    }

    @GetMapping("/api/articles")
    public  ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }


}
