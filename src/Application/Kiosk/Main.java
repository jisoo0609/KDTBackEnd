package Application.Kiosk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isInteger(String s) {
        if (s == null) {
            return false;
        } try {
            int select = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 1. 키오스크 첫 화면
        System.out.println("환영합니다!");
        while(true) {
            System.out.println("1. 주문하기");
            System.out.println("2. 종료");
            System.out.print("선택하세요: ");
            int select = sc.nextInt();

            if (select == 1){
                break;
            } else if (select == 2) {
                System.out.println("안녕히가세요~");
                break;
                // 프로그램 종료
            }else {
                throw new IOException("잘못된 숫자를 입력하셨습니다. \n 숫자를 다시 입력하세요");
            }
        }

        // 2. 주문하기
        List<Integer> cart = new ArrayList<>();

        List<String> readLines = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();

        while (true) {
            System.out.println("메뉴를 선택하세요.");

            // 파일 불러오기
            try (FileReader fileReader = new FileReader("menu.csv");
                 BufferedReader reader = new BufferedReader(fileReader)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    readLines.add(line);

                    String[] seperated = line.split(",");
                    Menu menu = new Menu(
                            Integer.parseInt(seperated[0]),
                            seperated[1],
                            Integer.parseInt(seperated[2])
                    );
                    menuList.add(menu);
                }
            } catch (IOException e) {
                System.out.println("Error Opening File: "+ e.getMessage());
            }

            for (Menu menu : menuList) {
                System.out.println(String.format("%d. <%s> - <%d>", menu.getNumber(), menu.getName(), menu.getPrice()));
            }

            System.out.println("메뉴 추가: 번호 입력");
            System.out.println("선택 확인: cart");
            System.out.println("결제하기: order");
            System.out.println("돌아가기: back");
            System.out.print("\n선택하세요: ");
            String select = sc.next();

            // select로 입력받은 값이 숫자가 아닌 경우
            if (!isInteger(select)){
                if("cart".equals(select)) {
                    break;
                    // 3. 장바구니로 넘어감
                }
                if ("order".equals(select)) {
                    break;
                    // 4. 결제하기로 넘어감
                }
                if ("back".equals(select)) {
                    break;
                    // 1. 첫 화면으로 넘어감
                }
            }

            if (Integer.parseInt(select) > menuList.size()) {
                System.out.println("메뉴가 없습니다.");
                System.out.println("돌아가기: back");
                System.out.println("선택하세요: ");
                select = sc.next();

                if ("back".equals(select)) {
                    // 돌아가기
                }
            }
            // 장바구니 추가
            System.out.println("선택되었습니다!");
            cart.add(Integer.parseInt(select));
        }

        // 3.
    }
}
