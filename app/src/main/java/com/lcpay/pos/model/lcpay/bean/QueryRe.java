package com.lcpay.pos.model.lcpay.bean;

public class QueryRe extends BaseRe {

    private String total_fee;
    private String end_time;
    private String out_trade_no;
    private String store_id;
    private String user_id;
    private String out_refund_no;

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {

        this.end_time = end_time;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }
}
