import javax.swing.*;
import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = scan.nextLine();

        String backwards = "";

        for (int i = str.length() - 1; i >= 0; i--){
            backwards += str.charAt(i);
        }

        if (str.equals(backwards)){
            System.out.println("Palindrome");
        }else {
            System.out.println("Not a Palindrome");
        }


    }
}
