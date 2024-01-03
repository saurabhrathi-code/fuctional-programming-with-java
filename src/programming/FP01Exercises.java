package programming;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printOddNumbersInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
                "AWS", "PCF","Azure", "Docker", "Kubernetes");

//        courses.stream()
//                .forEach(System.out::println);

//        courses.stream()
//                .filter(course -> course.contains("Spring"))
//                .forEach(System.out::println);

//        courses.stream()
//                .filter(course -> course.length() >= 4)
//                .forEach(System.out::println);

        //printCubesOfOddNumbersInListFunctional(numbers);
        courses.stream()
               .map(course -> course + ": " + course.length())
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 1) //Lambda Expression(==1 or !=0)
                .forEach(System.out::println);//Method Refer
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream() // convert to Stream
                .filter(number -> number%2 == 1) //Lambda Expression(==1 or !=0)
                .map(number -> number * number * number)
                .forEach(System.out::println);//Method Refer
    }

}