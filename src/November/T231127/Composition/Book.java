package November.T231127.Composition;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private Author author; // 구성(Composition). 다른 클래스의 속성 사용
    private LocalDateTime release;
    private String[] toc;
    private int price;
}
