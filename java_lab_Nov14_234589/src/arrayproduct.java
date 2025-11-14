import java.util.ArrayList;
import java.util.Scanner;

public class arrayproduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Phone", 50.00));
        products.add(new Product("Laptop", 10.00));
        products.add(new Product("WashingMachine", 20.00));
        products.add(new Product("Tv", 30.00));

        System.out.println("Enter price limit: ");
        double limit = scan.nextDouble();

        long count = products.stream()
                .filter(p -> p.price > limit)
                .count();

        System.out.println("Priduct that expensive than " + limit + ":" + count);



    }
}
