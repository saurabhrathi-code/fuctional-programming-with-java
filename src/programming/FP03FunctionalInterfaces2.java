package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {

    @SuppressWarnings("unsed")
    public static void main(String[] args) {

        //List<Integer> number = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0; // used to represent boolean condition //
        // Type Infer is not required in Lambda because if we write Predicate<Integer> means lambda will understand x
        // is type of integer

        Function<Integer, Integer> squareFunction = x -> x*x;

        Function<Integer, String> stringOutputFunction = x -> x + " "; // Integer input, String output

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x); //take input but no output

        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x+y; // if we will tell operator then all the input and
        // output of the same type. Binary Operator accepts two input and and returns one output of same type

        // No input ==> return something // Typically like a factory pattern
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);

        };

        //System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x; // input one, output one

        //System.out.println(unaryOperator.apply(10));


        //if you have two input in lambda expression and you want boolean then use biPredicate
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number<10 && str.length()>5;
        };
        System.out.println(biPredicate.test(2,"sitaram"));


        //if you have two input in lambda expression and you want any return then use biFunction
        BiFunction<Integer, String, String> biFunction = (number, str) ->{
            return number + " " + str;
        };

        System.out.println(biFunction.apply(2,"sitaram"));

        //if you have two input in lambda expression and you want any return nothing use biFunction
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept("ram","sita");

        BinaryOperator<Integer> binaryOperator2 = (x,y) -> x+y;

        IntBinaryOperator intBinaryOperator = (x, y) -> x+y;


         /* Primitive Functional Operators : Autoboxing will not required*/
        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator


        // Long, Double, Int

       // numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);






    }
}
