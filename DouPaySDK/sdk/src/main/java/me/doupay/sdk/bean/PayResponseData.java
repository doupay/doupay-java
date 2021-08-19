package me.doupay.sdk.bean;

public class PayResponseData {
    /*
    服务订单号
     */
    private String orderCode;
    /*
    h5地址
    */
    private String orderInfoUrl;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderInfoUrl() {
        return orderInfoUrl;
    }

    public void setOrderInfoUrl(String orderInfoUrl) {
        this.orderInfoUrl = orderInfoUrl;
    }

    @Override
    public String toString() {
        return "PayResponseData{" +
                "orderCode='" + orderCode + '\'' +
                ", orderInfoUrl='" + orderInfoUrl + '\'' +
                '}';
    }
}
