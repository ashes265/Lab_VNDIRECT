import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Page14 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
        Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics sum = list.stream().collect(collector);

        System.out.println("Total: " + sum.getSum());
        System.out.println("Average: " + sum.getAverage());
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value!");
                return;
            }
            list.add(n);
            System.out.println("Values: ");
            list.forEach(x -> {
                System.out.print(x + " - ");
            });
        };
        myConsumer.accept(6);
        Predicate<Integer> tester = v -> v > 5;
        Scanner sc = new Scanner(System.in);
        // while(true){
        // System.out.println("Please input a number: ");
        // int value=sc.nextInt();
        // myConsumer.accept(value);
        // System.out.println();
        // }
        while (true) {
            System.out.println("Please input a number: ");
            int value = sc.nextInt();
            if (value < 0)
                break;
            if (tester.test(value)) {
                myConsumer.accept(value);
            }
        }
        list.stream().filter(tester).forEach(x -> {
            System.out.println(x + " - ");
        });
        ;
        sc.close();

    }
}
