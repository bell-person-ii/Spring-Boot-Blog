package com.jong.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity //엔티티로 설정
@Getter //Getter 함수를 어노테이션으로 대신함
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티의 필수인 생성자를 어노테이션으로 대체 protected Article(){} 부분
public class Article {

    @Id //기본키 설정부 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
    @Column(name = "id", updatable = false) //칼럼이름은 id로 설정
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder // 객체 생성 방식 설정
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
