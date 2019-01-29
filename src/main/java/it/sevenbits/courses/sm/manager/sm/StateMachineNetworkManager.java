package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.manager.commands.CommandContext;
import it.sevenbits.courses.sm.manager.commands.CommandManager;
import it.sevenbits.courses.sm.manager.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private final Logger logger;

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
        logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        CommandContext commandContext = new CommandContext();
        CommandManager manager = new CommandManager(commandContext);
        MessageFormatter messageFormatter = new MessageFormatter();
        INetworkManagerCommand command;
        StringBuilder sb = new StringBuilder();
        try {
            while(!isInterrupted){
                while(network.hasPackage()){
                    NetworkPackage p = network.getPackage();
                    System.out.println(p.getType());
                    commandContext.setNetworkPackage(p);
                    commandContext.setMessageCollector(sb);
                    commandContext.setConsoleMessage(messageFormatter.getStringFormatByType(p.getType()));
                     command = manager.getCommand(currentState, p);
                    currentState = stateTransition.nextState(currentState, p);
                    command.execute();
                    System.out.println(p.getType() + currentState);
                }

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e){
            logger.error("Network manager was interrupted unexpectedly");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        logger.info("package listening is interrupted");
        isInterrupted = true;
    }
}
