package me.doupay.sdk.bean;

public class UserWithdrawCallBackResponse {
    /// 订单编号
    private String orderCode;

    /// 订单类型
    private String orderType ;

    /// 币种代码
    private String coinCode;
    /// 币种代码
    private String coinName;
    /// 地址
    private String address;

    /// 数量
    private String amount;

    /// 结果
    private boolean result;

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

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public UserWithdrawCallBackResponse(String orderCode, String orderType, String coinCode, String coinName,String address, String amount, boolean result) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.coinCode = coinCode;
        this.coinName = coinName;
        this.address = address;
        this.amount = amount;
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserWithdrawCallBackResponse{" +
                "orderCode='" + orderCode + '\'' +
                ", orderType='" + orderType + '\'' +
                ", coinCode='" + coinCode + '\'' +
                ", address='" + address + '\'' +
                ", amount='" + amount + '\'' +
                ", result=" + result +
                '}';
    }
}
