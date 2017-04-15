package org.vandeursen.java.functionalprogramming;

        import java.util.Arrays;
        import java.util.List;
        import java.util.function.Predicate;
        import java.util.stream.IntStream;

public class FunctionalProgrammingTest {

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));

        //Find the double of the first even number greater than 3
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);

        //Using lambda expressions
        System.out.println(
                values.stream()
                        .filter(e -> e > 3)
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .findFirst()
                        .get()
        );

        //Using method references
        System.out.println(
                values.stream()
                        //	.sorted()
                        //			.filter(e -> isGreaterThan3(e))
                        .filter(FunctionalProgrammingTest::isGreaterThan3)
                        .filter(FunctionalProgrammingTest::isEven)
                        .map(FunctionalProgrammingTest::doubleIt)
                        .findFirst()
                        .get()
        );
        //Using predicates
        Predicate<Integer> isGT3 = number -> number > 3;

        System.out.println(
                values.stream()
                        .filter(isGT3)
                        .filter(FunctionalProgrammingTest::isEven)
                        .map(FunctionalProgrammingTest::doubleIt)
                        .findFirst()
                        .get()
        );

    }

    private static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3: "+number);
        return number > 3;
    }

    private static boolean isEven(int number) {
        System.out.println("isEven: "+number);
        return number % 2 == 0;
    }

    private static int doubleIt(int number) {
        System.out.println("doubleIt: "+number);
        return number * 2;
    }

    private static boolean isPrime(final int number) {
// Imperative:
//		for (int i = 2; i < number; i++) {
//			if(number % i == 0) return false;
//		}
//		return number > 1;

//	Declarative:
        return number > 1 && IntStream.range(2, number)
                .noneMatch(index-> number % index == 0);
    }

}
