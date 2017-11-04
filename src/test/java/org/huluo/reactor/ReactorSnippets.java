package org.huluo.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;


public class ReactorSnippets {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    @Test
    public void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(s -> System.out.println(s));
        System.out.println();
        manyWords.subscribe(System.out::println);
    }

    @Test
    public void findingMissingLetter() {
        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        manyLetters.subscribe(System.out::println);
    }

    @Test
    public void testName() throws Exception {
        Flux<String> flux = Flux.just("abc", "aaa");

        flux = flux.flatMap(s -> Flux.fromArray(s.split(""))).distinct().sort().zipWith(Flux.range(1, Integer.MAX_VALUE),
                (string, count) -> String.format("%2d. %s", count, string));

        flux.subscribe(System.out::println);

    }
}