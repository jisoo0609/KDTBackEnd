package org.example.article.list;

import java.util.Scanner;

// 안내만 하는 역할
public class ArticleMain {
    public static void main(String[] args) {
        System.out.println("게시글 작성하기 1.");
        Scanner scanner = new Scanner(System.in);

        // 새 ArticleService를 만든다
        ArticleService articleService = new ArticleService(scanner);

        // 사용자가 종료를 원하는 flag
        boolean quit = false;
        while (!quit) {
            // 사용자에게 선택지를 제시하는 출력을 한다.
            System.out.println("1. 글 작성하기");
            System.out.println("2. 글 제목 목록 보기");
            System.out.println("3. 글 하나 보기");
            System.out.println("q. 종료");
            // 명령을 입력받는다.
            String command = scanner.nextLine();
            // 사용자의 입력에 따라 다른 기능을 실행한다.
            switch (command) {
                // 글 작성하기
                case "1":
                    articleService.writeArticle();
                    break;
                // 글 목록 보기
                case "2":
                    articleService.showAllTitles();
                    break;
                // 글 하나 보기
                case "3":
                    articleService.readArticle();
                    break;
                // 반복 종료하기
                case "q":
                    quit = true;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            System.out.println();
        }
        System.out.println("안녕히가세요~");
    }
}
