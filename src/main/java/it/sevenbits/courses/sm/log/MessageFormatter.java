package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

public class MessageFormatter {

    private final Map<String, String> map;

    public MessageFormatter() {
        this.map = new HashMap<>();
        map.put("MESSAGE", "Part of message: %1$s");
        map.put("TRASH", "Trash received");
        map.put("MESSAGE_START", "Message creating started");
        map.put("MESSAGE_FINISH", "Message creating finished");
    }

    public String getStringFormatByType(String type) {
        return map.getOrDefault(type, "Unknown package type");
    }
}
