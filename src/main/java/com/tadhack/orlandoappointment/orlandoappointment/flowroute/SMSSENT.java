package com.tadhack.orlandoappointment.orlandoappointment.flowroute;

public class SMSSENT {
    private String type;
    private String to;
    private String from;
    private String body;

    public SMSSENT(String type, String to, String from, String body) {
        this.type = type;
        this.to = to;
        this.from = from;
        this.body = body;
    }

    public SMSSENT() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "SMSSENT{" +
                "type='" + type + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
