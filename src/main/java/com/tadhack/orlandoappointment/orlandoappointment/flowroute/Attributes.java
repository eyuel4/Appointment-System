package com.tadhack.orlandoappointment.orlandoappointment.flowroute;

public class Attributes {
    private String to;
    private String from;
    private String body;

    public Attributes() {
    }

    public Attributes(String to, String from, String body) {
        this.to = to;
        this.from = from;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
