package it.sevenbits.courses.sm.manager.commands;

import it.sevenbits.courses.sm.network.NetworkPackage;

public class CommandContext {

    private NetworkPackage networkPackage;
    private String consoleMessage;
    private StringBuilder messageCollector;

    public CommandContext() {
    }

    public void setNetworkPackage(NetworkPackage networkPackage) {
        this.networkPackage = networkPackage;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public void setMessageCollector(StringBuilder messageCollector) {
        this.messageCollector = messageCollector;
    }

    public NetworkPackage getNetworkPackage() {
        return networkPackage;
    }

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public StringBuilder getMessageCollector() {
        return messageCollector;
    }
}
