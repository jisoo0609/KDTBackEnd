package November.T231129.D8Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class H1 {
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

            }
        }

        int sum = 0;
        for (int i=0; i< intlist.size(); i++) {
            System.out.print(intlist.get(i));
            if (i != intlist.size() -1) {
                System.out.print(" + ");
            }
            sum += intlist.get(i);
        }
        System.out.print(" = "+sum);
    }
}
