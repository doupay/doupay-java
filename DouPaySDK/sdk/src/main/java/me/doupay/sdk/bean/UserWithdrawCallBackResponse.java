package me.doupay.sdk.bean;

public class UserWithdrawCallBackResponse {
    /// 订单编号
    private String orderCode;

    /// 订单类型
    private String orderType ;

    /// 币种名称
    private String coinName;

    /// 协议名称
    private String protocolName;

    /// 地址
    private String address;

    /// 数量
    private String amountPaid;

    /// 结果
    private Boolean result;

    ///单价
    private String price;

    ///金额
    private String money;

    ///法币标识
    private String currency;

    /// 交易哈希
    private String hashId;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public UserWithdrawCallBackResponse(String orderCode, String orderType, String coinName,String protocolName	, String address, String amountPaid, Boolean result, String price, String money, String currency, String hashId) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.coinName = coinName;
        this.protocolName = protocolName;
        this.address = address;
        this.amountPaid = amountPaid;
        this.result = result;
        this.price = price;
        this.money = money;
        this.currency = currency;
        this.hashId = hashId;
    }

    @Override
    public String toString() {
        return "UserWithdrawCallBackResponse{" +
                "orderCode='" + orderCode + '\'' +
                ", orderType='" + orderType + '\'' +
                ", coinName='" + coinName + '\'' +
                ", protocolName='" + protocolName + '\'' +
                ", address='" + address + '\'' +
                ", amountPaid='" + amountPaid + '\'' +
                ", result=" + result +
                ", price='" + price + '\'' +
                ", money='" + money + '\'' +
                ", currency='" + currency + '\'' +
                ", hashId='" + hashId + '\'' +
                '}';
    }
}
