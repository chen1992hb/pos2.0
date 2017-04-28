package com.lcpay.pos.model.lcpay;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lcpay.pos.app.ApplicationLike;
import com.lcpay.pos.model.lcpay.bean.LcpayConfig;
import com.lcpay.pos.model.lcpay.bean.Operator;


/**
 * e城通支付相关本地配置
 *
 * @author linzhe
 */
public class LcpayPrefs {

    private final static String PREFS_NAME = "LcpayPrefs";

    /**
     * 清除配置
     */
    public static void clear() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Editor editor = preferences.edit();

        editor.clear();

        editor.commit();
    }

    /**
     * 读取本地配置
     *
     * @return
     */
    public static LcpayConfig getLcPayConfig() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        LcpayConfig lc = new LcpayConfig();

        lc.setId(preferences.getString("id", null));

        lc.setMerchant_name(preferences.getString("merchant_name", ""));

        lc.setMerchant_no(preferences.getString("merchant_no", null));

        lc.setStore_id(preferences.getString("store_id", null));

        lc.setStore_name(preferences.getString("store_name", ""));

        lc.setTerminal_id(preferences.getString("terminal_id", null));

        lc.setAccess_token(preferences.getString("access_token", null));

        return lc;

    }

    /**
     * 设置e城通
     */
    public static void setLcPayConfig(LcpayConfig lcpayConfig) {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Editor editor = preferences.edit();

        editor.putString("id", lcpayConfig.getId());

        editor.putString("merchant_name", lcpayConfig.getMerchant_name());

        editor.putString("merchant_no", lcpayConfig.getMerchant_no());

        editor.putString("store_id", lcpayConfig.getStore_id());

        editor.putString("store_name", lcpayConfig.getStore_name());

        editor.putString("terminal_id", lcpayConfig.getTerminal_id());

        editor.putString("access_token", lcpayConfig.getAccess_token());

        editor.commit();
    }


    /**
     * 读取操作员号
     *
     * @return
     */
    public static Operator getOperator() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Operator operator = new Operator();

        String operator_id = preferences.getString("operator_id", null);

        int role_type = preferences.getInt("role_type", 3);

        String nickname = preferences.getString("nickname", null);

        String username = preferences.getString("username", null);

        String phone = preferences.getString("phone", null);

        String email = preferences.getString("email", null);


        operator.setOperator_id(operator_id);

        operator.setRole_type(role_type);

        operator.setNickname(nickname);

        operator.setUsername(username);

        operator.setPhone(phone);

        operator.setEmail(email);

        return operator;
    }

    /**
     * 设置操作员号
     *
     * @param operator
     */
    public static void setOperator(Operator operator) {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Editor editor = preferences.edit();

        editor.putString("operator_id", operator.getOperator_id());

        editor.putInt("role_type", operator.getRole_type());

        editor.putString("nickname", operator.getNickname());

        editor.putString("username", operator.getUsername());

        editor.putString("phone", operator.getPhone());

        editor.putString("email", operator.getEmail());

        editor.commit();
    }

    /**
     * 设置折线图日期
     *
     * @return
     */
    public static void setCharDate(String currDate) {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Editor editor = preferences.edit();

        editor.putString("char_date", currDate);

        editor.commit();
    }

    /**
     * 设置折线图日期
     *
     * @return
     */
    public static String getCharDate() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String char_date = preferences.getString("char_date", null);

        return char_date;
    }


    /**
     * 获取当前流水号
     *
     * @return
     */
    public static int getCurTerminal_trace() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        int terminal_trace = preferences.getInt("terminal_trace", 0);

        return terminal_trace;
    }

    /**
     * 获取新的流水号
     *
     * @return
     */
    public static int getTerminal_trace() {

        SharedPreferences preferences = ApplicationLike.appContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // trace加1
        int terminal_trace = preferences.getInt("terminal_trace", 100000) + 1;

        Editor editor = preferences.edit();

        editor.putInt("terminal_trace", terminal_trace);

        editor.commit();

        return terminal_trace;
    }

}
