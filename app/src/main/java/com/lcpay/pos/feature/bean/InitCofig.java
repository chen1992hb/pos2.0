package com.lcpay.pos.feature.bean;


public class InitCofig {

    /**
     * 2016.1.25修改result为result_code  生成set和get方法
     */
    String result_code;

    String result_msg;

    String merchant_name;

    String merchant_no;

    String store_id;

    String store_name;

    String terminal_id;

    String id;

    String access_token;


    String merchant_no_uni;

    String terminal_id_uni;

    String auth_code;

    String ip;

    private String verno;
    private String downloadurl;
    private String changelog;

    String port;

    @Override
    public String toString() {
        return "InitCofig{" +
                "result_code='" + result_code + '\'' +
                ", result_msg='" + result_msg + '\'' +
                ", merchant_name='" + merchant_name + '\'' +
                ", merchant_no='" + merchant_no + '\'' +
                ", store_id='" + store_id + '\'' +
                ", store_name='" + store_name + '\'' +
                ", terminal_id='" + terminal_id + '\'' +
                ", id='" + id + '\'' +
                ", access_token='" + access_token + '\'' +
                ", merchant_no_uni='" + merchant_no_uni + '\'' +
                ", terminal_id_uni='" + terminal_id_uni + '\'' +
                ", auth_code='" + auth_code + '\'' +
                ", ip='" + ip + '\'' +
                ", verno='" + verno + '\'' +
                ", downloadurl='" + downloadurl + '\'' +
                ", changelog='" + changelog + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getMerchant_no_uni() {
        return merchant_no_uni;
    }

    public void setMerchant_no_uni(String merchant_no_uni) {
        this.merchant_no_uni = merchant_no_uni;
    }

    public String getTerminal_id_uni() {
        return terminal_id_uni;
    }

    public void setTerminal_id_uni(String terminal_id_uni) {
        this.terminal_id_uni = terminal_id_uni;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getVerno() {
        return verno;
    }

    public void setVerno(String verno) {
        this.verno = verno;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }


}
