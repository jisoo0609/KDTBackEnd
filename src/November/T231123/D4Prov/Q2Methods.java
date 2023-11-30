package November.T231123.D4Prov;
/*
    String 배열을 인자로 받아 배열의 각 값을
    한줄씩 출력하는 메서드 "printAll"를 작성하시오.
 */
public class Q2Methods {
    public static void printAll(String[] str){
        for (String s : str) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        String[] fruits = {"apple", "banana", "grape"};
        printAll(fruits);
    }
}
