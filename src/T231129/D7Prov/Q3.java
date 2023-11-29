package T231129.D7Prov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    어떤 가게의 메뉴 <메뉴명> <가격>형태로 계속 입력된다.
    "order"가 입력되었을 때,
    사용자의 단일 주문을 받고 금액을 출력하시오.
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> menu = new HashMap<>();

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] menuList = str.split(" ");

            if (str.equals("order")) {
                String order = sc.nextLine();
                System.out.println(menu.get(order));
                break;
            }
            menu.put(menuList[0], Integer.parseInt(menuList[1]));
        }
        // System.out.println(menu);
    }
}
