package io.vividcode.graalvm.resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ReadResourceContent {

    public static void main(String[] args) throws IOException {
        InputStream stream = Objects.requireNonNull(
                ReadResourceContent.class.getResourceAsStream("/input.txt"));
        String content = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
