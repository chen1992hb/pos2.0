package com.lcpay.pos.feature.bean.init;

import com.lcpay.pos.feature.bean.base.BaseResult;

import java.util.List;


/**
 * 用户列表数据
 *
 * @author lenovo
 */
public class GetUsers extends BaseResult {
    public List<User> userlist;

    public class User {
        @Override
        public String toString() {
            return "User{" +
                    "nickname='" + nickname + '\'' +
                    ", operator_id='" + operator_id + '\'' +
                    ", role_type='" + role_type + '\'' +
                    ", storeid='" + storeid + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }

        public String nickname;
        public String operator_id;
        public String role_type;
        public String storeid;
        public String username;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GetUsers [userlist=" + userlist + "]";
    }

}
