package org.example.article.jdbc;

// DTO = Data Transfer Object
// Article을 표현하기 위한 클래스
public class ArticleDto {
    private Integer id;
    private String title;
    private String content;

    public ArticleDto(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
