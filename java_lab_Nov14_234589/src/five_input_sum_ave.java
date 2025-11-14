import java.util.Scanner;
public class five_input_sum_ave {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] nums = new int[5];
        int sum = 0;

        System.out.println("Enter 5 numbers: ");

        for (int i = 0; i < 5; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }

        double average = sum / 5.0;

        System.out.println("total sum: " + sum);
        System.out.println("total average: " + average);


    }
}
