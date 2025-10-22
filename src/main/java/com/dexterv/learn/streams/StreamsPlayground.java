package com.dexterv.learn.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPlayground {
    public void nameStream() {
//        List<String> names = new ArrayList<>();
        List<String> names = List.of("Dexter", "John", "Jane","Jane", "Dex");

        names.stream()
                .filter(n->n.startsWith("J"))
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }

    public void wordFrequency() {
        Map<String, Long> result = List.of("apple", "banana", "apple", "orange", "banana", "apple")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}
