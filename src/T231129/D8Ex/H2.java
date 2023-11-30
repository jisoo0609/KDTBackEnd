package T231129.D8Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class H2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> intlist = new ArrayList<>();

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if ("q".equals(input)) {
                break;
            }
            try {
                intlist.add(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
                System.out.println(ignored.getMessage());
            }
        }
        System.out.println(intlist.size());

        int sum = 0;
        for (int i =0; i< intlist.size(); i++) {
            sum += intlist.get(i);
        }
        System.out.println(sum);
    }
}
