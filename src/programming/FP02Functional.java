package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
                "AWS", "PCF","Azure", "Docker", "Kubernetes");


//        0 12
//        12 9
//        21 13
//        34 4
//        38 6
//        44 2
//        46 4
//        50 12
//        62 15
//        77

        List<Integer> doubledNumbers = doubleList(numbers);

        List<Integer> evenNumbersOnly = evenList(numbers);

        List<Integer> lengthOfCourse = courseLengthList(courses);

        System.out.println(lengthOfCourse);

       // System.out.println(evenNumbersOnly);


       // System.out.println(doubledNumbers);

//        int sum = addListFunctional(numbers);
//        System.out.println(sum);
    }

    private static List<Integer> courseLengthList(List<String> courses) {
        return courses.stream()
                .map(course -> course.length())
                .collect(Collectors.toList());
    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number%2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
       return numbers.stream()
               .map(number -> number*number)
               .collect(Collectors.toList());
    }

    private static int sum(int aggregate , int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
               // .reduce(0, FP02Functional::sum); //Method Ref
              // .reduce(0, (x,y) -> x + y); // Lambda
               .reduce(0, Integer::sum);


                //Stream of number - One result value
                //Combine them into one result => One Value
                // 0 and (a,b) -> a + b or FP02Functional::sum

    }
}
