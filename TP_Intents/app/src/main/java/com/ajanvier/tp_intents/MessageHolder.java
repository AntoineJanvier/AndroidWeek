package com.ajanvier.tp_intents;

import java.io.Serializable;

/**
 * Created by antoine on 04/10/17.
 */

public class MessageHolder implements Serializable {
    private String message;

    public MessageHolder(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageHolder{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
