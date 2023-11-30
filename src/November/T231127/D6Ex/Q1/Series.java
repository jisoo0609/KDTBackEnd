package November.T231127.D6Ex.Q1;

public class Series extends Book {
    private String author; // 작가
    private String subTitle; // 부제
    private int seriesNumber; // 시리즈 숫자

    public Series(String title, int page, String author, String subTitle, int seriesNumber) {
        super(title, page);
        this.author = author;
        this.subTitle = subTitle;
        this.seriesNumber = seriesNumber;
    }

    public void printInfo() {
        System.out.println(String.format("제목: %s", getTitle()));
        System.out.println(String.format("페이지 수: %d", getPage()));
        System.out.println(String.format("작가: %s", this.author));
        System.out.println(String.format("부제: %s", this.subTitle));
        System.out.println(String.format("시리즈 번호: %d", this.seriesNumber));
    }
}
