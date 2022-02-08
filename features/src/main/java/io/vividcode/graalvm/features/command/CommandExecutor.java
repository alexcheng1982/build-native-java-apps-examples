package io.vividcode.graalvm.features.command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {

    private final Map<String, CommandFactory> commandFactories = new HashMap<>();

    public CommandExecutor() {
        InputStream inputStream = CommandExecutor.class.getResourceAsStream("/commands.txt");
        if (inputStream != null) {
            new BufferedReader(
                    new InputStreamReader(
                            inputStream,
                            StandardCharsets.UTF_8)).lines().forEach(line -> {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    try {
                        Class<?> clazz = Class.forName(parts[1], true, Thread.currentThread()
                                .getContextClassLoader());
                        commandFactories.put(parts[0],
                                (CommandFactory) clazz.getDeclaredConstructor().newInstance());
                        System.out.println("Added command factory " + parts[1]);
                    } catch (Exception e) {
                        System.err.println("Failed to create command factory " + parts[1]);
                    }
                }
            });
        }
    }

    public void execute(List<String> commands) {
        commands.forEach(command -> {
            CommandFactory commandFactory = commandFactories.get(command);
            if (commandFactory != null) {
                commandFactory.create().execute();
            }
        });
    }
}
