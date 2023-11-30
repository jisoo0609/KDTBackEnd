package November.T231127.D6Ex.Q1;

public abstract class Book {
    private String title; // 제목
    private int page; // 페이지 수

    public String getTitle() {
        return title;
    }

    public int getPage() {
        return page;
    }

    public Book(String title, int page) {
        this.title = title;
        this.page =page;
    }

    public abstract void printInfo();
}
