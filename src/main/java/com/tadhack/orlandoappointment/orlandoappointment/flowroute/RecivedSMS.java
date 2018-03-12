package com.tadhack.orlandoappointment.orlandoappointment.flowroute;

public class RecivedSMS {
    private String body;
    private String to;
    private String from;
    private String id;

    public RecivedSMS() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecivedSMS{" +
                "body='" + body + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
