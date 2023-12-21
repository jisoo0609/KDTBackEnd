package org.example.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 게시글은 제목과 내용으로 구성되어 있다.

// 1. 사용자는 반복해서 명령을 입력한다.
// 1-1. 사용자가 1을 입력하면, 게시글을 작성하는 메뉴를 선택한 것.
// 1-2. 사용자가 2를 입력하면, 작성된 게시글의 제목을 전부 나열하는 메뉴를 선택한것.
// 1-3. 사용자가 3을 입력하면, 게시글 상세보기 메뉴를 선택한 것.
// 1-4. 사용자가 q를 입력하면, 프로그램 종료 (main 메서드의 끝에 도달하는 것)

// 사용자는 반복해서 게시글을 작성할 수 있다.

// 실제로 게시글을 저장하고 생성하고 조회하는 클래스

// 일을 수행하는 역할
public class ArticleService {
    // 사용자의 입력을 받는 스캐너
    private Scanner scanner;
    // 사용자가 작성한 데이터를 담기 위한 리스트
    private final List<ArticleMem> articles;

    public ArticleService(Scanner scanner) {
        this.scanner = scanner;
        this.articles = new ArrayList<>();
    }

    // 1. 게시글을 작성해, articles에 저장하는 메서드
    public void writeArticle() {
        // 제목을 입력받는다
        System.out.print("제목을 입력하세요: ");
        String newTitle = this.scanner.nextLine();
        // 본문을 입력받는다
        System.out.print("본문을 입력하세요: ");
        String newContent = this.scanner.nextLine();
        // 게시글 목록에 저장한다
        ArticleMem newArticle = new ArticleMem(newTitle, newContent);
        this.articles.add(newArticle);
    }

    // 2. 작성된 게시글의 제목을 나열하는 메서드
    public void showAllTitles() {
        // 모든글을 순회할 것인데,
        // 사용자가 하나 보기에서 어떤 숫자를 넣을지를 판단할 수 있게
        // 하기 위하여, i를 같이 출력해준다.
        for (int i = 0; i < articles.size(); i++) {
            ArticleMem article = articles.get(i);
            System.out.println(String.format("%d. %s", i, article.getContent()));
        }
    }

    // 3. 하나의 게시글의 정보를 출력하는 메서드
    public void readArticle() {
        System.out.print("게시글 번호를 선택하세요: ");
        int idx = Integer.parseInt(scanner.nextLine());
        ArticleMem article = this.articles.get(idx);
        System.out.println(String.format("제목: %s", article.getTitle()));
        System.out.println(String.format("내용: %s", article.getContent()));
    }

}
