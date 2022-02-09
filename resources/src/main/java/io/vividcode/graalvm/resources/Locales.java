package io.vividcode.graalvm.resources;

import java.util.List;
import java.util.Locale;

public class Locales {

    public static void main(String[] args) {
        List.of(Locale.ITALY, Locale.FRANCE, Locale.US, Locale.CHINA)
                .forEach(locale ->
                        System.out.printf("Locale -> %s, Country name -> %s%n",
                                locale,
                                Locale.CHINA.getDisplayCountry(locale)));
    }
}
