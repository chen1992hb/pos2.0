package com.lcpay.pos.model.lcpay.bean;

public class Refund extends Base {

    public final String service_id = "030";
    private String refund_fee;
    private String out_trade_no;

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

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
