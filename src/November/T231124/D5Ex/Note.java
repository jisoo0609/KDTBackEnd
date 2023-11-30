package November.T231124.D5Ex;

public class Note {
    private String title; // 제목
    private String[] page; // 페이지
    private String[] contents; // 내용

    public Note(String title, String[] page) {
        this.title = title;
        this.page = page;
    }

    public void write(String[] page, String text) {
        int idx = 0;
        for (int i = 0; i<this.page.length; i++) {
            if (this.page[i].equals(page[i])) {
                contents[idx++] = text;
            }
        }
    }

    public String read(String[] page) {
        if (contents.length == 0) {
            return null;
        }
        return contents[page.length];
    }

    public int totalPage() {
        return page.length;
    }
}
