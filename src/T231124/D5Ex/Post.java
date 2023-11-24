package T231124.D5Ex;

import java.io.IOException;
import java.time.LocalDateTime;

public class Post {
    private String title; // 제목
    private String text; // 본문
    private final String password; // 비밀번호
    private LocalDateTime createdDate; // 작성일
    private LocalDateTime modificationDate; // 수정일

    public Post(String title, String text, String password) {
        this.title = title;
        this.text = text;
        this.password = password;
        createdDate = LocalDateTime.now();
        modificationDate = LocalDateTime.now();
    }

    public void printPost() {
        System.out.println(String.format("제목: <%s>", title));
        System.out.println(String.format("본문: <%s>", text));
        System.out.println(String.format("작성일: <%s>", createdDate));
        System.out.println(String.format("수정일: <%s>", modificationDate));
    }

    public boolean editTitle(String title, String password) {
        if (!password.equals(this.password)) {
            System.out.println("잘못된 비밀번호를 입력했습니다");
            return false;
        }
        this.title = title;
        modificationDate = LocalDateTime.now();
        System.out.println("제목을 수정했습니다.");
        return true;
    }

    public boolean editContent(String text, String password) {
        if (!password.equals(this.password)) {
            System.out.println("잘못된 비밀번호를 입력했습니다");
            return false;
        }
        this.text = text;
        modificationDate = LocalDateTime.now();
        System.out.println("본문을 수정했습니다.");
        return true;
    }
}