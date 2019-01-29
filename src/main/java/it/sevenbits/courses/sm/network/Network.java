package it.sevenbits.courses.sm.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final Logger logger = LoggerFactory.getLogger(Network.class);
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();

    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage(){
        logger.debug("got new package");
        return packages.removeFirst();
    }

    @Override
    public void addPackage(String message, String type) {
        if(packages.size() < maxSize) {
            logger.debug("added new package");
            packages.addLast(new NetworkPackage(type, message));
        }
        logger.error("couldn't add a new package");
    }
}
