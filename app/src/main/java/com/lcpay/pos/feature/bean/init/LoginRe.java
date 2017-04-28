package com.lcpay.pos.feature.bean.init;

import com.lcpay.pos.feature.bean.base.BaseResult;

public class LoginRe extends BaseResult {
    public String operator_id; // 操作员id
    public int role_type; // 角色类型
    public String nickname; // 用户昵称
    public String username; //用户名
    public String phone; // 手机
    public String email; // 邮箱

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public int getRole_type() {
        return role_type;
    }

    public void setRole_type(int role_type) {
        this.role_type = role_type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginRe{" +
                "operator_id='" + operator_id + '\'' +
                ", role_type=" + role_type +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
