package it.sevenbits.courses.sm.manager.commands;

import java.util.Objects;

public class InterruptedCommand implements INetworkManagerCommand {
    private CommandContext commandContext;

    public InterruptedCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    @Override
    public void execute() {
        System.out.println("message listening was interrupted! " + commandContext.getConsoleMessage());
        commandContext.getMessageCollector().setLength(0);
    }


}
