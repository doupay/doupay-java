package me.doupay.sdk.bean;

public class MakeUpCallBackResponse {
    /// 订单编号
    private String orderCode;
    /// 订单类型
    private String orderType;
    /// 协议名称
    private String coinName;
    /// 协议名称
    private String protocolName;
    /// 价格
    private String price;
    /// 地址
    private String address;
    /// 支付数量
    private String amountPaid;
    /// 金额
    private String money;
    /// 结果 true成功 false失败
    private Boolean result;
    /// 支付状态 1正常付款 2少付 3多付
    private Integer paymentStatus;

    /// 商家订单号
    private String orderNo;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public MakeUpCallBackResponse(String orderCode, String orderType, String coinName, String protocolName, String price, String address, String amountPaid, String money, Boolean result, Integer paymentStatus, String orderNo) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.coinName = coinName;
        this.protocolName = protocolName;
        this.price = price;
        this.address = address;
        this.amountPaid = amountPaid;
        this.money = money;
        this.result = result;
        this.paymentStatus = paymentStatus;
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "MakeUpCallBackResponse{" +
                "orderCode='" + orderCode + '\'' +
                ", orderType='" + orderType + '\'' +
                ", coinName='" + coinName + '\'' +
                ", protocolName='" + protocolName + '\'' +
                ", price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", amountPaid='" + amountPaid + '\'' +
                ", money='" + money + '\'' +
                ", result=" + result +
                ", paymentStatus=" + paymentStatus +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
