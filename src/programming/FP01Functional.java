package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //printALlNumbersInListFunctional(numbers);
        //printEvenNumbersInListFunctional(numbers);
        printSquareOfNumbersInListFunctional(numbers);

    }

//    private static void print(int number) {
//        System.out.println(number);
//    }

    private static void printALlNumbersInListFunctional(List<Integer> numbers) {
//        //[12,9,13,4,6,2,4,12,15]
//        //12
//        //9
//        //13
//        //4
//        //....
//
//        //what to do?
//        numbers.stream()
//                .forEach(FP01Functional::print); //Method Reference- form FP class we are calling print method using
//        // method reference.
//
//        // How to loop the numbers?
////        for (int number : numbers) {
////            System.out.println(number);
////        }

        numbers.stream()
                .forEach(System.out::println); // Method Reference
    }

//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }

    // number -> number %2 == 0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //what to do?
        numbers.stream()// convert to stream
                //.filter(FP01Functional::isEven) // Filter - Only Allow Even Numbers
                .filter(number -> number%2 == 0) //Lambda Expression
                .forEach(System.out::println);//Method Refer
    }

    private static void printSquareOfNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream() //Convert to Stream
                .filter(number -> number%2 == 0) //Lambda Expression
                //maping - x -> x * x;
                .map(x -> x*x) //.map(number -> number * number)
                .forEach(System.out::println);//Method Reference
    }

}