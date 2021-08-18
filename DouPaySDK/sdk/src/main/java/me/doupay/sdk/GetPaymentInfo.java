package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.net.BaseVo;
import me.doupay.sdk.net.ServerApi;
import me.doupay.sdk.net.exception.ApiString;
import retrofit2.Call;

import java.util.HashMap;
import java.util.Map;

/**
 * h5页面用到的几个不需要验签的接口
 */
public class GetPaymentInfo {
    /**
     * 获取订单信息
     * @param orderCode 订单号【长度20到50】
     */
    public  static BaseVo<OrderInfoResponseData> getOrderInfo(String orderCode) {

        if (orderCode == null || orderCode.isEmpty()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        Call<BaseVo<OrderInfoResponseData>> orderInfo = ServerApi.SERVICE_API.getOrderInfo(Constants.basrUrl + "openApi/getOrderInfo",map);
        try {
            BaseVo<OrderInfoResponseData> body = orderInfo.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }
    /*

     */

    /**
     * 获取支付信息
     * @param coinName  币种名称
     * @param chainCoinCode 链币种代码【长度4】,非必传
     * @param orderCode 订单号【长度10到30】
     */
    public static  BaseVo<PaymentInfoResponseData> getPaymentInfo (CoinNameEnum coinName, String chainCoinCode, String orderCode) {

        if (orderCode == null || coinName == null || orderCode.isEmpty()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("coinName",coinName);
        map.put("orderCode",orderCode);
        if (chainCoinCode != null && !chainCoinCode.isEmpty()) {
            map.put("chainCoinCode",chainCoinCode);
        }
        Call<BaseVo<PaymentInfoResponseData>> paymentInfo = ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "openApi/getPaymentInfo",map);
        try {
            BaseVo<PaymentInfoResponseData> body = paymentInfo.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 取消订单
     * @param orderCode 订单号
     */
    public static BaseVo<PayResponseData> cancleOrder (String orderCode) {
        if (orderCode == null || orderCode.equals("")) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);

        Call<BaseVo<PayResponseData>> baseVoCall =  ServerApi.SERVICE_API.cancleOrder(Constants.basrUrl + "openApi/cancel",map);
        try {
            BaseVo<PayResponseData> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 查询回调
     * @param orderCode  orderCode
     * @return
     */
    public static BaseVo<PaymentCallBackResponse> getCallback(String orderCode) {
        if (orderCode == null || orderCode.equals("")) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        Call<BaseVo<PaymentCallBackResponse>> baseVoCall =  ServerApi.SERVICE_API.getCallback(Constants.basrUrl + "openApi/getCallback",map);
        try {
            BaseVo<PaymentCallBackResponse> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }
}
