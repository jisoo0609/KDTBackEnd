package T231129.D8Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class H5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> menu = new HashMap<>();

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] menuList = str.split(" ");

            if (str.equals("order")) {
                break;
            }
            menu.put(menuList[0], Integer.parseInt(menuList[1]));
        }

        // 주문
        String order = sc.nextLine();
        System.out.println(menu.get(order));
    }
}
