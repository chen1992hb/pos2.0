package com.lcpay.pos.model.lcpay;

import android.annotation.TargetApi;
import android.os.Build;

import com.lcpay.pos.model.lcpay.bean.LcpayConfig;
import com.lcpay.pos.model.lcpay.bean.Operator;
import com.lcpay.pos.util.StringUtil;


public class LcpayData {

    //机器号
    private static String macid;
    //激活相关配置
    private static LcpayConfig lcpayConfig;
    //操作员
    private static Operator operator;

    /**
     * 获取机器号
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static String getMacid() {
        String id = macid;
        if (StringUtil.isNull(id)) {

            String SerialNumber = android.os.Build.SERIAL;

            id = SerialNumber;
        }

        return id;
    }


    /**
     * 清除支付配置
     */
    public static void clear() {

        lcpayConfig = null;
        LcpayPrefs.clear();

    }

    /**
     * 是否联机激活
     *
     * @return
     */
    public static boolean isInit() {

        if (lcpayConfig == null) {
            lcpayConfig = LcpayPrefs.getLcPayConfig();
        }

        if (StringUtil.isNull(lcpayConfig.getId()) || StringUtil.isNull(lcpayConfig.getMerchant_name()) || StringUtil.isNull(lcpayConfig.getMerchant_no()) || StringUtil.isNull(lcpayConfig.getTerminal_id()) || StringUtil.isNull(lcpayConfig.getAccess_token())) {

            return false;
        }
        return true;
    }

    /**
     * 获取支付配置
     *
     * @return
     */
    public static LcpayConfig getLcpayConfig() {

        if (lcpayConfig == null) {
            lcpayConfig = LcpayPrefs.getLcPayConfig();
        }
        return lcpayConfig;
    }

    /**
     * 设置支付配置
     *
     * @param id
     * @param merchant_no
     * @param terminal_id
     * @param access_token
     */
    public static void setLcpayConfig(String id, String merchant_name, String merchant_no, String store_id, String store_name, String terminal_id, String access_token) {
        if (lcpayConfig == null) {

            lcpayConfig = new LcpayConfig();
        }
        lcpayConfig.setId(id);
        lcpayConfig.setMerchant_name(merchant_name);
        lcpayConfig.setMerchant_no(merchant_no);
        lcpayConfig.setStore_id(store_id);
        lcpayConfig.setStore_name(store_name);
        lcpayConfig.setTerminal_id(terminal_id);
        lcpayConfig.setAccess_token(access_token);
        LcpayPrefs.setLcPayConfig(lcpayConfig);

    }

    /**
     * 是否登陆
     *
     * @return
     */
    public static boolean isLogin() {

        if (operator == null) {
            operator = LcpayPrefs.getOperator();
        }

//		if(operator.getType()==0||StringUtil.isNull(operator.getOperator_id())||StringUtil.isNull(operator.getOperator_name())){
//			return false;
//		}
//		新版本去掉了操作员
        if (StringUtil.isNull(operator.getOperator_id()) || StringUtil.isNull(operator.getUsername())) {
            return false;
        }
        return true;
    }


    /**
     * 获取操作员员
     *
     * @return
     */
    public static Operator getOperator() {
        if (operator == null) {
            operator = LcpayPrefs.getOperator();
        }
        return operator;
    }

    /**
     * 设置操作员
     *
     * @param operator_id
     */
    public static void setOperator(String operator_id, int role_type, String nickname, String username, String phone, String email) {


        if (operator == null) {

            operator = new Operator();
        }


        operator.setOperator_id(operator_id);

        operator.setRole_type(role_type);

        operator.setNickname(nickname);

        operator.setUsername(username);

        operator.setPhone(phone);

        operator.setEmail(email);

        LcpayPrefs.setOperator(operator);
    }


    public static void removeOperator() {


        operator = new Operator();


        LcpayPrefs.setOperator(operator);
    }

    /**
     * 获取流水号
     *
     * @wreturn
     */
    public static String getTerminal_trace() {

        int tt = LcpayPrefs.getTerminal_trace();

        String terminal_trace = String.format("%06d", tt);

        return terminal_trace;
    }


}
