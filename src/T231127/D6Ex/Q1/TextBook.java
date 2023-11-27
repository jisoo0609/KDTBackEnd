package T231127.D6Ex.Q1;

public class TextBook extends Book {
    private String subject; // 과목
    private int grade; // 학년

    public TextBook(String title, int page, String subject, int grade) {
        super(title, page);
        this.subject = subject;
        this.grade = grade;
    }

    public void printInfo() {
        System.out.println(String.format("제목: %s", getTitle()));
        System.out.println(String.format("페이지 수: %d", getPage()));
        System.out.println(String.format("과목: %s", this.subject));
        System.out.println(String.format("학년: %d", this.grade));
    }
}
