package com.lcpay.pos.model.lcpay;


import com.lcpay.pos.model.lcpay.bean.Cancel;
import com.lcpay.pos.model.lcpay.bean.CancelRe;
import com.lcpay.pos.model.lcpay.bean.Pay;
import com.lcpay.pos.model.lcpay.bean.PayRe;
import com.lcpay.pos.model.lcpay.bean.Prepay;
import com.lcpay.pos.model.lcpay.bean.PrepayRe;
import com.lcpay.pos.model.lcpay.bean.Query;
import com.lcpay.pos.model.lcpay.bean.QueryRe;
import com.lcpay.pos.model.lcpay.bean.Refund;
import com.lcpay.pos.model.lcpay.bean.RefundRe;
import com.lcpay.pos.model.lcpay.bean.Sign;
import com.lcpay.pos.model.lcpay.bean.SignRe;

/**
 * 签名处理
 *
 * @author linzhe
 */
public class LcpaySign {


    /**
     * 支付拼装
     *
     * @param pay
     * @return
     */
    public static String getPay(Pay pay) {
        String payStr = "pay_ver=" + pay.getPay_ver() + "&pay_type="
                + pay.getPay_type() + "&service_id=" + pay.getService_id()
                + "&merchant_no=" + pay.getMerchant_no() + "&terminal_id="
                + pay.getTerminal_id() + "&terminal_trace="
                + pay.getTerminal_trace() + "&terminal_time="
                + pay.getTerminal_time() + "&auth_no=" + pay.getAuth_no()
                + "&total_fee=" + pay.getTotal_fee();

        return payStr;
    }


    /**
     * 预支付拼装
     *
     * @return
     */
    public static String getPrepay(Prepay prePay) {
        String prepayStr = "pay_ver=" + prePay.getPay_ver() + "&pay_type="
                + prePay.getPay_type() + "&service_id="
                + prePay.getService_id() + "&merchant_no="
                + prePay.getMerchant_no() + "&terminal_id="
                + prePay.getTerminal_id() + "&terminal_trace="
                + prePay.getTerminal_trace() + "&terminal_time="
                + prePay.getTerminal_time() + "&total_fee="
                + prePay.getTotal_fee();

        return prepayStr;
    }

    /**
     * 查询拼装
     *
     * @param query
     * @return
     */
    public static String getQuery(Query query) {
        String queryStr = "pay_ver=" + query.getPay_ver() + "&pay_type="
                + query.getPay_type() + "&service_id=" + query.getService_id()
                + "&merchant_no=" + query.getMerchant_no() + "&terminal_id="
                + query.getTerminal_id() + "&terminal_trace="
                + query.getTerminal_trace() + "&terminal_time="
                + query.getTerminal_time() + "&out_trade_no="
                + query.getOut_trade_no();

        return queryStr;
    }

    /**
     * 退款拼装
     *
     * @param refund
     * @return
     */
    public static String getRefund(Refund refund) {
        String refundStr = "pay_ver=" + refund.getPay_ver() + "&pay_type="
                + refund.getPay_type() + "&service_id="
                + refund.getService_id() + "&merchant_no="
                + refund.getMerchant_no() + "&terminal_id="
                + refund.getTerminal_id() + "&terminal_trace="
                + refund.getTerminal_trace() + "&terminal_time="
                + refund.getTerminal_time() + "&refund_fee="
                + refund.getRefund_fee() + "&out_trade_no="
                + refund.getOut_trade_no();

        return refundStr;
    }

    /**
     * 撤销拼装
     *
     * @param cancel
     * @return
     */
    public static String getCancel(Cancel cancel) {
        String cancelStr = "pay_ver=" + cancel.getPay_ver() + "&pay_type="
                + cancel.getPay_type() + "&service_id="
                + cancel.getService_id() + "&merchant_no="
                + cancel.getMerchant_no() + "&terminal_id="
                + cancel.getTerminal_id() + "&terminal_trace="
                + cancel.getTerminal_trace() + "&terminal_time="
                + cancel.getTerminal_time();

        return cancelStr;
    }

    /**
     * 签名拼装
     *
     * @param sign
     * @return
     */
    public static String getSign(Sign sign) {
        String signStr = "pay_ver=" + sign.getPay_ver() + "&service_id="
                + sign.getService_id() + "&merchant_no="
                + sign.getMerchant_no() + "&terminal_id="
                + sign.getTerminal_id() + "&terminal_trace="
                + sign.getTerminal_trace() + "&terminal_time="
                + sign.getTerminal_time();

        return signStr;
    }


    /**
     * 支付返回拼装
     *
     * @param payRe
     * @return
     */
    public static String getPayRe(PayRe payRe) {

        String payReStr = "return_code=" + payRe.getReturn_code()
                + "&return_msg=" + payRe.getReturn_msg();

        if ("01".equals(payRe.getReturn_code())) {

            payReStr += "&result_code=" + payRe.getResult_code()
                    + "&pay_type=" + payRe.getPay_type()
                    + "&merchant_name=" + payRe.getMerchant_name()
                    + "&merchant_no=" + payRe.getMerchant_no()
                    + "&terminal_id=" + payRe.getTerminal_id()
                    + "&terminal_trace=" + payRe.getTerminal_trace()
                    + "&terminal_time=" + payRe.getTerminal_time()
                    + "&total_fee=" + payRe.getTotal_fee()
                    + "&end_time=" + payRe.getEnd_time()
                    + "&out_trade_no=" + payRe.getOut_trade_no();
        }

        return payReStr;
    }

    /**
     * 预支付返回拼装
     *
     * @param prepayRe
     * @return
     */
    public static String getPrepayRe(PrepayRe prepayRe) {

        String prepayReStr = "return_code=" + prepayRe.getReturn_code()
                + "&return_msg=" + prepayRe.getReturn_msg();

        if ("01".equals(prepayRe.getReturn_code())) {

            prepayReStr += "&result_code=" + prepayRe.getResult_code()
                    + "&pay_type=" + prepayRe.getPay_type()
                    + "&merchant_name=" + prepayRe.getMerchant_name()
                    + "&merchant_no=" + prepayRe.getMerchant_no()
                    + "&terminal_id=" + prepayRe.getTerminal_id()
                    + "&terminal_trace=" + prepayRe.getTerminal_trace()
                    + "&terminal_time=" + prepayRe.getTerminal_time()
                    + "&total_fee=" + prepayRe.getTotal_fee()
                    + "&out_trade_no=" + prepayRe.getOut_trade_no()
                    + "&qr_code=" + prepayRe.getQr_code();
        }


        return prepayReStr;
    }

    /**
     * 查询返回拼装
     *
     * @param queryRe
     * @return
     */
    public static String getQueryRe(QueryRe queryRe) {

        String queryReStr = "return_code=" + queryRe.getReturn_code()
                + "&return_msg=" + queryRe.getReturn_msg();

        if ("01".equals(queryRe.getReturn_code())) {

            queryReStr += "&result_code=" + queryRe.getResult_code()
                    + "&pay_type=" + queryRe.getPay_type()
                    + "&merchant_name=" + queryRe.getMerchant_name()
                    + "&merchant_no=" + queryRe.getMerchant_no()
                    + "&terminal_id=" + queryRe.getTerminal_id()
                    + "&terminal_trace=" + queryRe.getTerminal_trace()
                    + "&terminal_time=" + queryRe.getTerminal_time()
                    + "&total_fee=" + queryRe.getTotal_fee()
                    + "&end_time=" + queryRe.getEnd_time()
                    + "&out_trade_no=" + queryRe.getOut_trade_no();
        }

        return queryReStr;
    }

    /**
     * 退款返回拼装
     *
     * @param refundRe
     * @return
     */
    public static String getRefundRe(RefundRe refundRe) {

        String refundReStr = "return_code=" + refundRe.getReturn_code()
                + "&return_msg=" + refundRe.getReturn_msg();

        if ("01".equals(refundRe.getReturn_code())) {

            refundReStr += "&result_code=" + refundRe.getResult_code()
                    + "&pay_type=" + refundRe.getPay_type()
                    + "&merchant_name=" + refundRe.getMerchant_name()
                    + "&merchant_no=" + refundRe.getMerchant_no()
                    + "&terminal_id=" + refundRe.getTerminal_id()
                    + "&terminal_trace=" + refundRe.getTerminal_trace()
                    + "&terminal_time=" + refundRe.getTerminal_time()
                    + "&refund_fee=" + refundRe.getRefund_fee()
                    + "&end_time=" + refundRe.getEnd_time()
                    + "&out_trade_no=" + refundRe.getOut_trade_no()
                    + "&out_refund_no=" + refundRe.getOut_refund_no();
        }
        return refundReStr;
    }

    /**
     * 撤销返回拼装
     *
     * @param cancelRe
     * @return
     */
    public static String getCancelRe(CancelRe cancelRe) {

        String cancelReStr = "return_code=" + cancelRe.getReturn_code()
                + "&return_msg=" + cancelRe.getReturn_msg();

        if ("01".equals(cancelRe.getReturn_code())) {

            cancelReStr += "&result_code=" + cancelRe.getResult_code()
                    + "&pay_type=" + cancelRe.getPay_type()
                    + "&merchant_name=" + cancelRe.getMerchant_name()
                    + "&merchant_no=" + cancelRe.getMerchant_no()
                    + "&terminal_id=" + cancelRe.getTerminal_id()
                    + "&terminal_trace=" + cancelRe.getTerminal_trace()
                    + "&terminal_time=" + cancelRe.getTerminal_time()
                    + "&recall=" + cancelRe.getRecall();
        }
        return cancelReStr;
    }

    /**
     * 签到返回拼装
     *
     * @param signRe
     * @return
     */
    public static String getSignRe(SignRe signRe) {

        String signReStr = "return_code=" + signRe.getReturn_code()
                + "&return_msg=" + signRe.getReturn_msg();

        if ("01".equals(signRe.getReturn_code())) {

            signReStr += "&result_code=" + signRe.getResult_code()
                    + "&merchant_no=" + signRe.getMerchant_no()
                    + "&terminal_id=" + signRe.getTerminal_id()
                    + "&terminal_trace=" + signRe.getTerminal_trace()
                    + "&terminal_time=" + signRe.getTerminal_time()
                    + "&access_token=" + signRe.getAccess_token();
        }
        return signReStr;
    }


}
