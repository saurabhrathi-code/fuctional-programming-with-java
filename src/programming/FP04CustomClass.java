package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class  Course {
    private String name;
    private String category;
    private int reviewScore;
    private  int noOfStudent;

    public Course(String name, String category, int reviewScore, int noOfStudent) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudent = noOfStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public String toString() {
        return name + ":" + noOfStudent + ":" + reviewScore;
    }
}


public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses =
        List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
                );

        //allMatch, noneMatch, anyMatch

        //allMatch - it is returns a true if every element in the stream matches the condition
        //noneMatch - it is returns a true if No element in the stream matches the condition specified
        //anyMatch - it is returns a true if any/atleast one  element in the stream matches the condition specified

        Predicate<Course> reviewScoreGreaterThan95Predicate =
                createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate =
                createPredicateWithCutoffReviewScore(90);

        Predicate<Course> reviewScoreLessThan90Predicate =
                course -> course.getReviewScore() < 90;


        System.out.println(courses.stream()
                .allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan90Predicate));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudent);

        Comparator<Course> comparingByNoOfStudentsIncreasing =
                Comparator.comparingInt(Course::getNoOfStudent); //use primitives like comparingInt, comparingDouble
        // to reduce Autoboxing.

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsIncreasing)
                .collect(Collectors.toList()));

        //OutPut: [FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        Comparator<Course> comparingByNoOfStudentsDecreasing =
                Comparator.comparing(Course::getNoOfStudent)
                        .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));

        //OutPut : [Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98,Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews =
                Comparator.comparing(Course::getNoOfStudent)
                        .thenComparing(Course::getReviewScore)
                        .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .collect(Collectors.toList()));

        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]


        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList())
        );
        //output: [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]

        System.out.println(
                courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .collect(Collectors.toList())
        );
        // output: [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        System.out.println(
                courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList())
        );
        //output : [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

        System.out.println(courses);
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore()>=95) // once condition will pass it will skip
                        // after that all.
                        .collect(Collectors.toList()));
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

        System.out.println(
             courses.stream()
             .dropWhile(course -> course.getReviewScore() >= 95)
             .collect(Collectors.toList()));
        //[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]


        System.out.println(
                courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviews) // max - it will return last element from the list
        ); //output: Optional[FullStack:14000:91]

        System.out.println(
                courses.stream()
                .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 2000))

        ); // output : Optional[Microservices:25000:96]

        System.out.println(
                courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 2000)));

        //Optional provide you a way to check if a result exist or not
        //Optional.empty
        //Kubernetes:2000:91

        System.out.println(
                courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .findFirst()); // outPut: Optional.empty

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()); // output : Optional[Spring:20000:98]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()); // Optional[Spring:20000:98]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        //.map(course -> course.getNoOfStudent())
                        .mapToInt(Course::getNoOfStudent)
                        .sum()); //OutPut: 88000

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudent)
                .average()); //Output: OptionalDouble[22000.0]

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudent)
                .count()); // outPut: 4

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudent)
                        .max()); // OptionalInt[25000]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudent)
                        .min()); // OptionalInt[20000]


        System.out.println(
                courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
                //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,
                                        Collectors.toList()))));
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}


        Predicate<Course> reviewScoreGreaterThan95Predicate2 =
                createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2 =
                createPredicateWithCutoffReviewScore(90);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;




    }
}
