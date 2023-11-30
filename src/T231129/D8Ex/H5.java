package T231129.D8Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class H5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> menu = new HashMap<>();
        Map<String, Integer> order = new HashMap<>();

        // 메뉴 입력
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] menuList = str.split(" ");

            if (str.equals("order")) {
                break;
            }
            menu.put(menuList[0], Integer.parseInt(menuList[1]));
        }

        // 주문 리스트
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] orderList = str.split(" ");

            if (str.equals("done")) {
                break;
            }
            order.put(orderList[0], Integer.parseInt(orderList[1]));
        }

        // 주문 금액 총 합
        int sum = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            // 주문이 메뉴에서 일치하는 경우
            if (menu.containsKey(item)) {
                // 가격 가져옴
                int price = menu.get(item);
                sum += price*count;
            }
        }
        System.out.println(sum);
    }
}
