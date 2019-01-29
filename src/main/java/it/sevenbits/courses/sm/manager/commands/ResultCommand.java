package it.sevenbits.courses.sm.manager.commands;

import java.util.Objects;

public class ResultCommand implements INetworkManagerCommand {

    private CommandContext commandContext;

    public ResultCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    @Override
    public void execute() {
        System.out.println(commandContext.getConsoleMessage() + "! " + commandContext.getMessageCollector());
        commandContext.getMessageCollector().setLength(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultCommand that = (ResultCommand) o;
        return Objects.equals(commandContext, that.commandContext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandContext);
    }
}
