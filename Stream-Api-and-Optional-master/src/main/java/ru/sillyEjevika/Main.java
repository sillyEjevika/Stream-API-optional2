package ru.sillyEjevika;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Задача №1 (ч1)
        List<Integer> integers = List.of(1, 2, 4, 5, 6, 9, 3, 10, 7, 8);
        List<String> strings = List.of("a", "b", "f", "g", "c", "d");
        findMinMax(integers.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальное число: " + x + "\nМаксимальное число: " + y));
        findMinMax(strings.stream(), String::compareTo, (x, y) -> System.out.println("Первая буква: " + x + "\nПоследняя буква: " + y));

        // Задача №1 (ч2)
        printNumberOfEven(integers);
    }

    // Задача №1
    private static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }

    }

    // Задача №2
    private static void printNumberOfEven(List<Integer> integers){
        System.out.println("Кол-во чётных чисел: " + integers.stream()
                .filter(x -> x % 2 == 0)
                .peek(System.out::println)
                .count());
    }
}