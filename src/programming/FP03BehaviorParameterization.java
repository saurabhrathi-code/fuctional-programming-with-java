package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 12, 15);

        //filterAndPrint(numbers, x1 -> x1 % 2 == 0);

        //filterAndPrint(numbers, x -> x % 2 != 0);


        filterAndPrint(numbers, x-> x % 3 == 0);

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        List<Integer> squareNumber = mapAndCreateNewList(numbers, integerIntegerFunction);
        List<Integer> cubeNumber = mapAndCreateNewList(numbers, x -> x * x * x);
        List<Integer> doubleNumber = mapAndCreateNewList(numbers, x -> x + x);

        System.out.println(doubleNumber);


    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


/*
        numbers.stream()
                .filter(x -> x%2==0) //refactor variable
                .forEach(System.out::println);

        numbers.stream()
                .filter(x -> x%2!=0)
                .forEach(System.out::println);
*/

/*
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;  //inline variable

        numbers.stream()
                .filter(evenPredicate)
                .forEach(System.out::println);   // extract method

        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);
*/


}
