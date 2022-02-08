package io.vividcode.graalvm.features.command;

import io.vividcode.graalvm.features.command.Commands.Run;
import io.vividcode.graalvm.features.command.Commands.Sleep;
import io.vividcode.graalvm.features.command.Commands.Think;

public class CommandFactories {

    public static class RunCommandFactory implements CommandFactory {

        @Override
        public Command create() {
            return new Run();
        }
    }

    public static class ThinkCommandFactory implements CommandFactory {

        @Override
        public Command create() {
            return new Think();
        }
    }

    public static class SleepCommandFactory implements CommandFactory {

        @Override
        public Command create() {
            return new Sleep();
        }
    }
}
