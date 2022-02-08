package io.vividcode.graalvm.features.command;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Commands are required!");
            System.exit(1);
        }
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.execute(List.of(args[0].split(",")));
    }
}
