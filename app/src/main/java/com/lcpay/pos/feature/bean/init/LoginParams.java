package com.lcpay.pos.feature.bean.init;

public class LoginParams {
    private String operator_id;
    private String password;
    private String macid;
    private String device_token;

    public String getMacid() {
        return macid;
    }

    public void setMacid(String macid) {
        this.macid = macid;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }


}
