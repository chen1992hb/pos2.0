package com.lcpay.pos.model.lcpay.bean;

public class Prepay extends Base {

    public final String service_id = "011";
    private String total_fee;
    private String order_body;

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getOrder_body() {
        return order_body;
    }

    public void setOrder_body(String order_body) {
        this.order_body = order_body;
    }

    public String getService_id() {
        return service_id;
    }


}
