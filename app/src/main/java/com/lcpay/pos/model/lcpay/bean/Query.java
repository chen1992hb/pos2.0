package com.lcpay.pos.model.lcpay.bean;

public class Query extends Base {

    public final String service_id = "020";
    private String out_trade_no;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getService_id() {
        return service_id;
    }


}
