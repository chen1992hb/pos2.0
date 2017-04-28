package com.lcpay.pos.model.lcpay.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 流水列表
 *
 * @author lenovo
 */
public class TradeListQuery implements Serializable {
    public String result_code;
    public String result_msg;
    public Trade_page trade_page;

    public class Trade_page implements Serializable {
        public List<ContentInfo> content;
        public String firstPage;
        public String lastPage;
        public String number;
        public String numberOfElements;
        public String size;
        public List<Sort> sort;
        public String totalElements;
        public String totalPages;
    }

    public class ContentInfo implements Serializable {
        public String balance;
        public String createtime;
        public String end_time;
        public String id;
        public String is_notice;
        public String merchant_name;
        public String merchant_no;
        public String merchant_type;
        public String operator_id;
        public String order_body;
        public String out_refund_no;
        public String out_trade_no;
        public String payStatusMsg;
        public String pay_mode;
        public String pay_status;
        public String pay_status_msg;
        public String poundage;
        public String refund_fee;
        public String refund_status;
        public String refund_status_msg;
        public String refund_time;
        public String storename;
        public String terminal_id;
        public String terminal_time;
        public String terminal_trace;
        public String total_fee;
        public String type;
        public String wx_bank_type;
        public String wx_openid;
        public String wx_result_code;
        public String wx_result_msg;
        public String wx_transaction_id;
        public String zfb_result_code;
        public String zfb_result_msg;
        public String zfb_trade_no;
    }

    public class Sort implements Serializable {
        public String ascending;
        public String direction;
        public String property;
    }
}
