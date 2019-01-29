package it.sevenbits.courses.sm.manager.commands;

import it.sevenbits.courses.sm.manager.sm.Pair;
import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<Pair<State, String>, INetworkManagerCommand> commandsMap;
    private final INetworkManagerCommand ignore;
    public CommandManager(CommandContext commandContext) {
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");
        State defaultState = new State("IGNORE");

        ignore = new TrashIgnoringCommand(commandContext);
        INetworkManagerCommand append = new MessageAppendCommand(commandContext);
        INetworkManagerCommand result = new ResultCommand(commandContext);
        INetworkManagerCommand interrupted = new InterruptedCommand(commandContext);
        INetworkManagerCommand start = new StartCommand(commandContext);
        INetworkManagerCommand finish = new FinishCommand(commandContext);

        commandsMap = new HashMap<>();
        commandsMap.put(new Pair<>(defaultState, "MESSAGE_START"), start);
        commandsMap.put(new Pair<>(defaultState, "MESSAGE_FINISH"), ignore);
        commandsMap.put(new Pair<>(defaultState, "MESSAGE"), ignore);
        commandsMap.put(new Pair<>(defaultState, "TRASH"), ignore);

        commandsMap.put(new Pair<>(listenState, "MESSAGE"), append);
        commandsMap.put(new Pair<>(listenState, "TRASH"), ignore);
        commandsMap.put(new Pair<>(listenState, "MESSAGE_START"), ignore);
        commandsMap.put(new Pair<>(listenState, "MESSAGE_FINISH"), finish);

        commandsMap.put(new Pair<>(stubSuspicion, "MESSAGE_START"), ignore);
        commandsMap.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), finish);
        commandsMap.put(new Pair<>(stubSuspicion, "MESSAGE"), append);
        commandsMap.put(new Pair<>(stubSuspicion, "TRASH"), interrupted);
    }
    public INetworkManagerCommand getCommand(State state, NetworkPackage p) {
        return commandsMap.getOrDefault(new Pair<>(state, p.getType()), ignore);
    }
}
