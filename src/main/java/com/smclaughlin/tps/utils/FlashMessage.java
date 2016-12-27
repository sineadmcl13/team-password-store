package com.smclaughlin.tps.utils;


/**
 * Created by sineadmclaughlin on 14/12/2016.
 */
public class FlashMessage {

    public static String FLASH_MESSAGE = "flashMessage";

    public enum MessageType {
        SUCCESS, ERROR, INFO
    }

    private MessageType type;
    private String message;

    public FlashMessage(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
