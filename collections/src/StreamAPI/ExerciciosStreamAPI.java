package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        // numerosAleatorios.stream().forEach(new Consumer<String>() {
        // @Override
        // public void accept(String s) {
        // System.out.println(s);
        // }
        // });

        // numerosAleatorios.stream().forEach(s -> System.out.println(s));

        // numerosAleatorios.forEach(s -> System.out.println(s));

        // numerosAleatorios.forEach(System.out::println);

        // numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

        Set<String> collectSet = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());

        // numerosAleatorios.stream().map(new Function<String,Integer>() {
        // @Override
        // public Integer apply(String s) {
        // return Integer.parseInt(s);
        // }
        // });

        // numerosAleatorios.stream().map(s -> Integer.parseInt(s));

        // numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> collectList = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());
        // collectList.forEach(System.out::println);

        List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        // System.out.println(ListParesMaioresQue2);

        // numerosAleatorios.stream()
        // .mapToInt(Integer::parseInt)
        // .average().ifPresent(System.out::println);

        List<Integer> removerImpares = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());

        removerImpares.removeIf(i -> (i % 2 != 0));
        System.out.println(removerImpares);

    }
}
