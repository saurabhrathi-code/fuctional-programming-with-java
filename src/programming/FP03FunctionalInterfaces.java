package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,12,15);

/*
        boolean isEven(int x) {
            return x%2==0;
        }

        int squared(int x) {
            return x*x;
        }
*/

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
// OR Without lambda
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        Consumer<Integer> sysoutConsumer = System.out::println;

        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2); // or .forEach(x-> System.out.println(x))



        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        //BinaryOperator<Integer> sumBinaryOperator3 = (x,y) -> x+y;

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };

        int sum = numbers.stream()
                .reduce(0, sumBinaryOperator);
        System.out.println("sum: "+sum);
    }
}
