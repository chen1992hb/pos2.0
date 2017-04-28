package com.lcpay.pos.model.lcpay.bean;

public class Sign {

    public final String pay_ver = "100";
    public final String service_id = "090";
    private String merchant_no;
    private String terminal_id;
    private String terminal_trace;
    private String terminal_time;
    private String key_sign;

    public String getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getTerminal_trace() {
        return terminal_trace;
    }

    public void setTerminal_trace(String terminal_trace) {
        this.terminal_trace = terminal_trace;
    }

    public String getTerminal_time() {
        return terminal_time;
    }

    public void setTerminal_time(String terminal_time) {
        this.terminal_time = terminal_time;
    }

    public String getKey_sign() {
        return key_sign;
    }

    public void setKey_sign(String key_sign) {
        this.key_sign = key_sign;
    }

    public String getPay_ver() {
        return pay_ver;
    }

    public String getService_id() {
        return service_id;
    }


}
