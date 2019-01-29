package it.sevenbits.courses.sm.manager.commands;

import java.util.Objects;

public final class MessageAppendCommand implements INetworkManagerCommand {

    private final CommandContext commandContext;

    public MessageAppendCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    @Override
    public void execute() {
        String consoleMessage = commandContext.getConsoleMessage();
        int index = consoleMessage.lastIndexOf("%");
        String msg = consoleMessage.substring(0, index);
        String format = consoleMessage.substring(index);
        System.out.println(msg + String.format(format, commandContext.getNetworkPackage().getMessage()));
        commandContext.getMessageCollector().append(commandContext.getNetworkPackage().getMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAppendCommand that = (MessageAppendCommand) o;
        return Objects.equals(commandContext, that.commandContext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandContext);
    }
}
