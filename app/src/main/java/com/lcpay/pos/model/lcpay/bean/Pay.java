package com.lcpay.pos.model.lcpay.bean;

public class Pay extends Base {

    public final String service_id = "010";
    private String auth_no;
    private String total_fee;
    private String order_body;

    public String getAuth_no() {
        return auth_no;
    }

    public void setAuth_no(String auth_no) {
        this.auth_no = auth_no;
    }

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
