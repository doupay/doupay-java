package me.doupay.sdk.bean;

public class MakeUpCallBackResponse {
    /// 订单编号
    private String orderCode;

    /// 订单类型
    private String orderType ;

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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public MakeUpCallBackResponse(String orderCode, String orderType, boolean result) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.result = result;
    }
}
