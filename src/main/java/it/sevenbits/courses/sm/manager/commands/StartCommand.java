package it.sevenbits.courses.sm.manager.commands;

import java.util.Objects;

public class StartCommand implements INetworkManagerCommand {

    private CommandContext commandContext;

    public StartCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    @Override
    public void execute() {
        System.out.println(commandContext.getConsoleMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartCommand that = (StartCommand) o;
        return Objects.equals(commandContext, that.commandContext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandContext);
    }
}
