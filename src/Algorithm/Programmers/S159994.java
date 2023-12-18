package Algorithm.Programmers;

public class S159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Idx = 0;
        int cards2Idx = 0;

        for (String word : goal) {
            if (cards1Idx < cards1.length && cards1[cards1Idx].equals(word)) {
                cards1Idx++;
                continue;
            }

            if (cards2Idx < cards2.length && cards2[cards2Idx].equals(word)) {
                cards2Idx++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        new S159994().solution(cards1, cards2, goal);
    }
}
