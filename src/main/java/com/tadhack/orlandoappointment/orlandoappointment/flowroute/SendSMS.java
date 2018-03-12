package com.tadhack.orlandoappointment.orlandoappointment.flowroute;

public class SendSMS {
    private String type;
    private Attributes attributes;

    public SendSMS() {
    }

    public SendSMS(String type, Attributes attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "SendSMS{" +
                "type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
