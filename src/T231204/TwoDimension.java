package T231204;

public class TwoDimension {
    public static void main(String[] args) {
        // 3 * 3 크기의 배열
        int[][] tdArray = new int[3][3];

        // tdArray[i]는 tdArray의 i번째 줄
        int[] tdArrayRow = tdArray[1];
        System.out.println(tdArrayRow[0]);
        System.out.println(tdArrayRow[1]);
        System.out.println(tdArrayRow[2]);

        System.out.println(tdArray[1][0]);

        // 1부터 9까지 오른쪽 그림대로 tdArray에 값 할당
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tdArray[i][j] = num;
                num++;
            }
        }

        // 만약 들어갈 데이터를 다 알고 있다면
        // 그냥 넣어줄 수 있다
        tdArray = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    public static void deltaSearch() {
        // 0은 공원, 1은 장애물
        int[][] park = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1 ,0},
                {0, 0, 0, 0}
        };

        int y = 0;
        int x = 0;

        String[] routes = new String[] {
                "N 1",
                "E 2",
                "S 2",
                "W 2"
        };

        String[] route = routes[0].split(" ");
        // 방향과 크기를 나누어 저장한다
        String direction = route[0];
        int distance = Integer.parseInt(route[1]);
        // 주어진 정보를 바탕으로 y와 x를 조작한다
        switch (direction) {
            case "N":
                y -= distance;
                break;
                // 다른 case도 넣어줘야 한다'
                // 실수하기 쉽다
        }

        int[][] deltas = new int[][] {
                // N 방향으로 갈때 좌표 변경
                {-1, 0},
                // S 방향으로 갈 때 좌표 변경
                {1, 0},
                // W 방향으로 갈 때 좌표 변경
                {0, -1},
                // E 방향으로 갈 때 좌표 변경
                {0, 1}
        };

        int[] delta = null;
        switch (direction) {
            case "N":
                delta = deltas[0];
                break;
        }

        // 방향만 정해주면 델타 배열이 얼마나 이동할지를 결정한다
        y += distance * delta[0];
        x += distance * delta[1];
    }
}
