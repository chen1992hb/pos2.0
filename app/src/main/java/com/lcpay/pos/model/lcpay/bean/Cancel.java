package com.lcpay.pos.model.lcpay.bean;

public class Cancel extends Base {

    public final String service_id = "040";
    private String out_trade_no;
    private String pay_trace;
    private String pay_time;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getPay_trace() {
        return pay_trace;
    }

    public void setPay_trace(String pay_trace) {
        this.pay_trace = pay_trace;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getService_id() {
        return service_id;
    }


}
