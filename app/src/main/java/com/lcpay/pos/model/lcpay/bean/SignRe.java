package com.lcpay.pos.model.lcpay.bean;

public class SignRe {

    private String return_code;
    private String return_msg;
    private String result_code;
    private String merchant_no;
    private String terminal_id;
    private String terminal_trace;
    private String terminal_time;
    private String access_token;
    private String key_sign;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getKey_sign() {
        return key_sign;
    }

    public void setKey_sign(String key_sign) {
        this.key_sign = key_sign;
    }


}
