import java.util.Scanner;
public class fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("give me how many fibonacci terms you want: ");
        int terms = scan.nextInt();

        int num1 = 0, num2 = 1;

        System.out.println("fibonacci series up to " + terms + " terms ");

        for (int i = 1; i <= terms; i++) {
            System.out.println(num1 + " ");

            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;}





    }

}
