package com.tadhack.orlandoappointment.orlandoappointment.flowroute;

public class Data {
    private SendSMS data;

    public Data() {
    }

    public Data(SendSMS data) {
        this.data = data;
    }

    public SendSMS getData() {
        return data;
    }

    public void setData(SendSMS data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
