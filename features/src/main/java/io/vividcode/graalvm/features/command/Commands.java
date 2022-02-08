package io.vividcode.graalvm.features.command;

public class Commands {

    public static class Run implements Command {

        @Override
        public void execute() {
            System.out.println("Run!");
        }
    }

    public static class Think implements Command {

        @Override
        public void execute() {
            System.out.println("Think...");
        }
    }

    public static class Sleep implements Command {

        @Override
        public void execute() {
            System.out.println("Sleep");
        }
    }


}
