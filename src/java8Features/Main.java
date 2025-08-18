package java8Features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /*
        A Stream<T> is not a data structure but a sequence of elements from a source (e.g. Collection, Array, I/O)
        that supports functional-style aggregate operations like filter, map, and reduce
        Streams are lazy: intermediate operations are only executed when a terminal operation is invoked
        Streams can be sequential or parallel, enabling efficient use of multi-core systems for large datasets

        Ways to initialize streams
        From collections: list.stream() or list.parallelStream()
        From arrays: Arrays.stream(arr) or Stream.of(...)
        Infinite streams: Stream.generate(...), Stream.iterate(...)
        Primitive streams like IntStream, LongStream, DoubleStream to reduce boxing overhead

        Intermediate Operations (Lazy)
        These return a stream and can be chained. They include:
        Stateless: filter(), map(), flatMap(), peek()  -> doesn't store state applies operation on elements individually
        Stateful: distinct(), sorted(), skip(), limit() (these require buffering or order awareness)

        Terminal Operations
        These produce a result (or side-effect) and end the pipeline:
        Reduction: reduce(), collect()
        Consumption: forEach()
        Short-circuiting: findFirst(), anyMatch(), allMatch()—can stop early even in infinite streams
         */

        Random rnd = new Random();
        Stream.generate(rnd::nextInt)
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        // Easy level
        List<Integer> intList = Arrays.asList(1, 4, 8, 3, 5, 7, 2, 3,1);
        List<Integer> evenList = intList.stream().filter(i -> i % 2 == 0)
                            .toList(); // this returns the immutable list
        List<Integer> squareList = intList.stream().map(i -> i * i)
                                                .toList();
        System.out.println("evenList: "+evenList);
        System.out.println("squareList: "+squareList);

        List<String> stringList = Arrays.asList("Java", "runs", "on", "3billion", "devices");
        List<String> gtFiveList = stringList.stream().filter(s -> s.length() > 5)
                                    .collect(Collectors.toList());
        System.out.println("gtFiveList: "+gtFiveList);

        List<String> stringList2 = Arrays.asList("","hi", "how", "Are", "you");
        List<String> startsWithAlist = stringList2.stream()
                .collect(Collectors.filtering(s -> s.startsWith("A"), Collectors.toList()));
        System.out.println("startsWithAlist "+startsWithAlist);
        List<String> startsWithAList2 = stringList2.stream().filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("startsWithAList2: "+startsWithAList2);


        List<Integer> sortedList = intList.stream().sorted((x,y) -> Integer.compare(y,x)).collect(Collectors.toList());
        System.out.println("sortedList: "+sortedList);

        // Medium Level ---------------------------------------------------------------------------------------
        List<Integer> distinctList = intList.stream().distinct().toList();
        System.out.println("distinctList: "+distinctList);

        Integer sumOfSquares = intList.stream().map(i -> i * i).reduce(0,Integer::sum);
        System.out.println("sumOfSquares: "+sumOfSquares);

        List<String> longestWord = stringList.stream().sorted((x, y) -> Integer.compare(y.length(), x.length()))
                        .limit(1).toList();
        System.out.println("longestWord: "+longestWord);
        List<String> longestWordV2 = stringList.stream().sorted(Comparator.comparing(String::length).reversed())
                .limit(1).collect(Collectors.toList());
        System.out.println("longestWordV2: "+longestWordV2);

        Optional<String> longestWord1 = stringList.stream()
                        .max(Comparator.comparingInt(String::length));
        System.out.println("longestWord1: "+longestWord1.get());

        List<String> stringList3 = Arrays.asList("aa", "b", "ccd", "aa", "ccd", "dde", "ccd");
        Map<Integer, List<String>> groupByLen = stringList3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("groupByLen: "+groupByLen);

        Map<Integer, Set<String>> groupByLenUnique = stringList3.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("groupByLenUnique: "+groupByLenUnique);

        List<Integer> skipAndLimit = intList.stream().skip(2).limit(3).collect(Collectors.toList());
        System.out.println("skipAndLimit: "+skipAndLimit);

        String joinedString = stringList.stream().collect(Collectors.joining(",", "(", ")"));
        System.out.println("joinedString: "+joinedString);

        Optional<String> firstNonEmpty = stringList2.stream().filter(s -> !s.equals("")).findFirst();
        System.out.println("firstNonEmpty: "+firstNonEmpty.get());

        Map<Boolean, List<Integer>> evenOdd = intList.stream()
                .collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println("evenOdd: "+evenOdd);

        Map<String, Integer> groupByElements = stringList3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(a -> 1)));
        System.out.println("groupByElements: "+groupByElements);

        // Advanced level ------------------------------------------------------------------
        List<List<Integer>> listOfList = List.of(List.of(1, 4, 5), List.of(3, 6, 2), List.of(8, 1, 2));
        List<Integer> flatMapList = listOfList.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatMapList);

        Optional<Integer> secondHighest = intList.stream()
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst();
        System.out.println("secondHighest: "+secondHighest);

        String mostFreqWord = stringList3.stream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse("");
        System.out.println("mostFreqWord: "+mostFreqWord);

        List<String> sortByLenThenAlpha = stringList.stream()
                                            .sorted(Comparator.comparing(String::length)
                                            .thenComparing(Comparator.naturalOrder()))
                                            .collect(Collectors.toList());
        System.out.println("sortByLenThenAlpha: "+sortByLenThenAlpha);

        List<Employee> employees = List.of(new Employee("emp1", 25, "dept1"),
                new Employee("emp2", 25, "dept2"),
                new Employee("emp3", 28, "dept2"),
                new Employee("emp4", 21, "dept3"),
                new Employee("emp5", 35, "dept4"),
                new Employee("emp6", 42, "dept3"),
                new Employee("emp7", 36, "dept5"));
        Map<String, List<Employee>> grpByDept = employees.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("grpByDept: "+grpByDept);


        Map<String, Employee> empGrpByDeptOlder = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                               Collectors.collectingAndThen(
                                       Collectors.maxBy(Comparator.comparingInt(Employee::getAge)),
                                       emp -> emp.orElse(null)
                               )));
        System.out.println("empGrpByDeptOlder: "+empGrpByDeptOlder );

        List<Integer> topNLargestNums = intList.stream().sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("topNLargestNums: "+topNLargestNums);

        List<String> stringList4 = List.of("abba", "level", "java", "device", "pop");
        List<String> palidromeList = stringList4.stream()
                .filter(s -> new StringBuilder(s).reverse().toString().equals(s))
                .toList();
        System.out.println("palidromeList: "+palidromeList);

        Double avgAge = employees.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("avgAge: "+avgAge);

        List<Employee> sortByDeptAgeName = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getAge)
                        .thenComparing(Employee::getName))
                .toList();
        System.out.println("sortByDeptAgeName: "+sortByDeptAgeName);

        Map<Integer, Long> histogramByWordLength = stringList3.stream()
                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("histogramByWordLength: "+histogramByWordLength);

        List<Integer> numMoreThanOnce = intList.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        System.out.println("numMoreThanOnce: "+numMoreThanOnce);

        List<Transaction> transactions = new ArrayList<>(Arrays.asList(
                new Transaction(4000, "Jhon", 2021),
                new Transaction(6000, "Alex", 2018),
                new Transaction(2000, "Sam", 2023),
                new Transaction(1000, "Bill", 2019),
                new Transaction(8000, "Jhon", 2020),
                new Transaction(3000, "Alex", 2019),
                new Transaction(4000, "Jhon", 2020)
        ));

        Map<String, Integer> collect = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getName,
                        Collectors.summingInt(Transaction::getValue)));
        System.out.println(collect);
    }

}

class Transaction{
    private int value;
    private String name;
    private int year;

    public Transaction(int value, String name, int year) {
        this.value = value;
        this.name = name;
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
