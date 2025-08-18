package java8Features;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Hello world! This is a test.",
                "This test is only a test.",
                "In case of an actual emergency, the signal you just heard would be followed by official information.",
                "Hello again: world, hello!",
                "Test cases are useful. Tests test code, and code must pass tests."
        );
        int topK = 3;
        List<String> topKMostFreqWords = sentences.stream()
                .map(s -> s.replaceAll("\\p{Punct}", " "))
                .flatMap(s -> Stream.of(s.split(" ")))
                .map(s -> s.toLowerCase().trim())
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(s -> 1)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topK)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("topKMostFreqWords: "+topKMostFreqWords);

        List<EmployeeV> employees = Arrays.asList(
                new EmployeeV(1, "Alice", 75000.0, "Engineering"),
                new EmployeeV(2, "Bob", 50000.0, "Engineering"),
                new EmployeeV(3, "Charlie", 90000.0, "HR"),
                new EmployeeV(4, "Diana", 60000.0, "HR"),
                new EmployeeV(5, "Evan", 120000.0, "Sales"),
                new EmployeeV(6, "Fiona", 115000.0, "Sales"),
                new EmployeeV(7, "George", 70000.0, "Engineering"),
                new EmployeeV(8, "Helen", 95000.0, "Finance"),
                new EmployeeV(9, "Ian", 90000.0, "Finance"),
                new EmployeeV(10, "Jane", 110000.0, "HR")
        );

        List<EmployeeV> grpByDeptHighSal = employees.stream()
                .collect(Collectors.groupingBy(EmployeeV::dept,
                        Collectors.maxBy(Comparator.comparingDouble(EmployeeV::salary))))
                .values()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());
        System.out.println("grpByDeptHighSal: "+grpByDeptHighSal);


        List<LocalDate> dates = List.of(
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 2),
                LocalDate.of(2024, 1, 2),   // duplicate
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 2, 10),
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2023, 12, 31),
                LocalDate.of(2024, 1, 1),   // duplicate
                LocalDate.of(2024, 1, 15),
                LocalDate.of(2024, 1, 20)
        );
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end   = LocalDate.of(2024, 1, 15);
        List<LocalDate> localDatesBWStartAndEnd = dates.stream()
                .filter(ld -> (ld.isAfter(start)) && ld.isBefore(end))
                .collect(Collectors.toList());
        System.out.println("localDatesBWStartAndEnd: "+localDatesBWStartAndEnd);


        List<List<Integer>> listOfLists = List.of(
                List.of(10, 3, 5, 3, 11),
                List.of(6, 7, 10, 13, 5),
                List.of(2, 20, 13, 17),
                List.of(7, 19, 2, 11),
                List.of(23, 1, 5, 3)
        );

        List<Integer> numsFlatDistinctSortPrime = listOfLists.stream()
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .filter(num -> {
                    if(num == 1) return false;
                    for (int i = 2; i < num; i++) {
                        if (num % i == 0) return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        System.out.println("numsFlatDistinctSortPrime: "+numsFlatDistinctSortPrime);

        List<String> list = Arrays.asList(
                "10, 5, 3, abc, 5",
                "2,4,6,foo,10",
                "7, 11, 13, 5.5, -3",
                "100,200,301,hello,200",
                ",,42,, , -5, 42"
        );

        list.stream()
                .flatMap(l -> Arrays.stream(l.split(",")))
                .filter(s -> {
                    for(Character ch : s.toCharArray()){
                        if(!Character.isDigit(ch)) return false;
                    }
                    return true;
                })
                .collect(Collectors.partitioningBy(i -> Integer.parseInt(i)%2==0))
                .entrySet()
                .stream();
                //.sorted((e1,e2) -> Integer.compare(e1.getValue(), e2.getValue()))



    }
}

record EmployeeV(int id, String name, double salary, String dept){}
