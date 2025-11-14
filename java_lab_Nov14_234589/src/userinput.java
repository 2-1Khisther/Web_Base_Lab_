import java.util.Scanner;
public class userinput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Your name: ");
        String name = scan.nextLine();

        System.out.print("What is your age: ");
        int age = scan.nextInt();


        System.out.println("Hello, I am " + name + " and I'm " + age + " years old");


    }
}