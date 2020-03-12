package com.swan.ee;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilsTest {

    @Test
    public void mapsTest() {
        Map<String, String> maps = new HashMap<>();
        maps.put("device", "A01");
        maps.put("size", "B02");

        System.out.println(maps);

        String[] values = {"dev", "siz"};
        System.out.println(values);

        Set<String> keyName = maps.keySet();
        System.out.println(keyName);

        Set<Map.Entry<String, String>> entries = maps.entrySet();
//        for (Map.Entry<String, String> str  : entries) {
//            System.out.println(str.getKey());
//            System.out.println(str.getValue());
//        }
        Stream<String> stringStream = Arrays.stream(values).map(x -> x.concat("a"));
        Set<String> collect = stringStream.collect(Collectors.toSet());
        System.out.println(collect);

        Stream<Integer> integerStream = Arrays.stream(values).map(x -> x.length());
        List<Integer> collect1 = integerStream.collect(Collectors.toList());
        System.out.println(collect1);

        Stream<String> stringStream1 = Arrays.stream(values).map(x ->
               keyName.stream().filter(y -> y.contains(x)).findAny().get()
        );

        stringStream1.forEach(System.out::println);


        Stream<String> stringStream2 = maps.entrySet().stream()
                .map(x -> Arrays.stream(values)
                        .filter(y -> x.getKey().contains(y))
                        .findAny()
                        .get()
                        .substring(0, 1)
                        .concat(x.getValue().substring(1))
                );
        stringStream2.forEach(System.out::println);

        List<String[]> collect2 = maps.entrySet().stream()
                .flatMap(x -> Arrays.stream(values)
                        .filter(y -> x.getKey().contains(y))
                        .map(j -> new String[]{x.getKey(), j.substring(0, 1).concat(x.getValue().substring(1))}))
                .collect(Collectors.toList());

        String[] strings = collect2.get(0);
        System.out.println(strings[0] + " / " +strings[1]);

        Map<String, String> result = new HashMap<>();

        maps.entrySet().stream()
                .forEach(x -> {

                            String value =
                            Arrays.stream(values)
                                    .filter(y -> x.getKey().contains(y))
                                    .findAny()
                                    .get()
                                    .substring(0, 1)
                                    .concat(x.getValue().substring(1));

                            result.put(x.getKey(), value);
                        }
                );

        System.out.println(result);


        Map<String, String> code = new HashMap<>();
        code.put("device", "F");
        code.put("size", "H");


        Map<String, String> result2 = new HashMap<>();
        maps.entrySet().stream()
                .forEach(x -> {
                    String concat = code.entrySet().stream()
                            .filter(y -> x.getKey().contains(y.getKey()))
                            .findAny()
                            .get().getValue().substring(0, 1).concat(x.getValue().substring(1));
                    result2.put(x.getKey(), concat);
                        }
                );
        System.out.println(result2);
    }
}
