package com.jong.blog.service;

import com.jong.blog.domain.Article;
import com.jong.blog.dto.AddArticleRequest;
import com.jong.blog.dto.UpdateArticleRequest;
import com.jong.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor // 생성자 추가
@Service // 빈등록
public class BlogService {
    private final BlogRepository blogRepository;

    // JPA에서 제공하는 함수 save 를 통한 DB 저장 구현
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity()); //엔티티 타입객체인 request 를 세이브 함수를 통해 DB에 저장
    }

    public  List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found " + id));

    }
    // deleteById 함수를 통해 DB에서 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

        article.update(request.getTitle(),request.getContent());
        return article;
    }

}
