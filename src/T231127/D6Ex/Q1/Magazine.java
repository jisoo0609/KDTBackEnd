package T231127.D6Ex.Q1;

public class Magazine extends Book {
    private String date; // 출간 날짜
    private String theme; // 주제

    public Magazine(String title, int page,String date, String subject) {
        super(title, page);
        this.date = date;
        this.theme = subject;
    }

    public void printInfo() {
        System.out.println(String.format("제목: %s", getTitle()));
        System.out.println(String.format("페이지 수: %d", getPage()));
        System.out.println(String.format("출간 날짜: %s", this.date));
        System.out.println(String.format("주제: %s", this.theme));
    }
}
