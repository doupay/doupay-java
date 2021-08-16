package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.enums.RefundType;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import me.doupay.sdk.net.BaseVo;
import me.doupay.sdk.net.ServerApi;
import me.doupay.sdk.net.exception.ApiString;
import me.doupay.sdk.sign.AES;
import me.doupay.sdk.sign.RSAUtils;
import org.json.JSONObject;
import retrofit2.Call;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaymentInfo {
    /**
     * 获取币种列表
     */
    public static BaseVo<CoinResponseData>  getCoinList () {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999, ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
        Call<BaseVo<CoinResponseData>> coinList = ServerApi.SERVICE_API.getCoinList(Constants.basrUrl + "trade/getCoinList", map);
        try {
            BaseVo<CoinResponseData> body = coinList.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 获取法币列表
     */
    public static BaseVo<CurrencyResponseData> getCurrencyList() {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
      Call<BaseVo<CurrencyResponseData>> currentList =  ServerApi.SERVICE_API.getCurrencyList(Constants.basrUrl + "trade/getCurrencyList",map);
        try {
            BaseVo<CurrencyResponseData> body = currentList.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public static BaseVo<CoinChainCodeResp> getCoinChainCodes(CoinNameEnum coinName) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        Map<String,Object> map = new HashMap<>();
        map.put("appId",Constants.getAppId());
        map.put("coinName",coinName);
        Call<BaseVo<CoinChainCodeResp>> currentList =  ServerApi.SERVICE_API.getCoinChainCodes(Constants.basrUrl + "trade/getChainCoins",map);
        try {
            BaseVo<CoinChainCodeResp> body = currentList.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 获取订单信息
     * @param orderCode 订单号【长度20到50】
     */
    public  static   BaseVo<OrderInfoResponseData> getOrderInfo(String orderCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }


        if (orderCode == null || orderCode.isEmpty()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        Call<BaseVo<OrderInfoResponseData>> orderInfo = ServerApi.SERVICE_API.getOrderInfo(Constants.basrUrl + "trade/getOrderInfo",map);
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
    public static  BaseVo<PaymentInfoResponseData> getPaymentInfo (CoinNameEnum coinName,String chainCoinCode, String orderCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }

        if (orderCode == null || coinName == null || orderCode.isEmpty()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("coinName",coinName);
        map.put("orderCode",orderCode);
        if (chainCoinCode != null && !chainCoinCode.isEmpty()) {
            map.put("chainCoinCode",chainCoinCode);
        }
        Call<BaseVo<PaymentInfoResponseData>> paymentInfo = ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/getPaymentInfo",map);
        try {
            BaseVo<PaymentInfoResponseData> body = paymentInfo.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 付款,当orderType为0001时,amount内容为金额,currencyCode为必传,当orderType为0002时amount内容为数量,coinName为必传
     * @param amount        金额
     * @param coinName      币种(BTC)
     * @param currencyCode  法币(0001:人民币cny,美元usa)【长度3到4】
     * @param merchantUser  商家用户【长度10到20之间】
     * @param orderNo       订单号【长度10到30】
     * @param subject       商品标题【长度5~10】
     * @param body          商品描述信息【长度10到100】
     * @param description   附加说明【长度10到50】
     * @param orderType     订单类型(BY_AMOUNT、BY_MONEY)
     */
    public  static  BaseVo<PayResponseData>  pay ( String money,
            String amount, CoinNameEnum coinName, CurrencyCodeEnum currencyCode,
            String merchantUser, String orderNo, String subject,
            String body, String description,
            OrderTypeCodeEnum orderType ) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }
        // 大于1800小于7200
        if (new BigDecimal(Constants.getExpireTime()).compareTo(new BigDecimal("1800")) == -1) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError8));
        }
        if (new BigDecimal(Constants.getExpireTime()).compareTo(new BigDecimal("7200")) == 1) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError8));
        }

        if ( orderNo == null || orderType == null
                || subject == null ||  orderNo.isEmpty()  || subject.isEmpty()
            ) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        if (orderType != OrderTypeCodeEnum.BY_AMOUNT
                && orderType != OrderTypeCodeEnum.BY_MONEY) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError7));
        }

        if (orderType == OrderTypeCodeEnum.BY_MONEY) {
            if (currencyCode == null || money == null || money.equals("")) {
                return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError1));

            }
        }

        if (orderType == OrderTypeCodeEnum.BY_AMOUNT) {
            if (coinName == null || amount == null || amount.equals("")) {
                return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError2));
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("appId",Constants.getAppId());
        map.put("expireTime",Constants.getExpireTime());
        map.put("merchantUser",merchantUser);
        map.put("orderNo",orderNo);
        map.put("orderType",orderType);
        map.put("subject",subject);
        if (body != null && !body.equals("")) {
            map.put("body",body);
        }
        if (description != null && !description.equals("")) {
            map.put("description",description);
        }

        if (orderType == OrderTypeCodeEnum.BY_MONEY) {
            map.put("money",money);
            map.put("currency",currencyCode);
        }
        if (orderType == OrderTypeCodeEnum.BY_AMOUNT) {
            map.put("amount",amount);
            map.put("coinName",coinName);
        }
        Call<BaseVo<PayResponseData>> gotoPay =  ServerApi.SERVICE_API.gotoPay(Constants.basrUrl + "trade/pay",map);
        try {
            BaseVo<PayResponseData> responseBody = gotoPay.execute().body();
            return responseBody;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 补单
     * @param orderCode  orderCode
     * @return
     */
    public static BaseVo<MakeUpResponse> maleUp(String remark, String orderCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        if (orderCode == null || remark == null || orderCode.equals("") || remark.equals("")) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        map.put("appId",Constants.getAppId());
        map.put("remark",remark);
        map.put("timeStamp",System.currentTimeMillis());
        Call<BaseVo<MakeUpResponse>> baseVoCall =  ServerApi.SERVICE_API.makeup(Constants.basrUrl + "trade/makeUpOrder",map);
        try {
            BaseVo<MakeUpResponse> body = baseVoCall.execute().body();
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
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        if (orderCode == null || orderCode.equals("")) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        Call<BaseVo<PaymentCallBackResponse>> baseVoCall =  ServerApi.SERVICE_API.getCallback(Constants.basrUrl + "trade/getCallback",map);
        try {
            BaseVo<PaymentCallBackResponse> body = baseVoCall.execute().body();
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
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        if (orderCode == null || orderCode.equals("")) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);

        Call<BaseVo<PayResponseData>> baseVoCall =  ServerApi.SERVICE_API.cancleOrder(Constants.basrUrl + "trade/cancel",map);
        try {
            BaseVo<PayResponseData> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 退款
     * @param address       退款地址【长度5到50】
     * @param amount        退款数量【长度1到50
     * @param orderCode     订单编号【长度5到50】
     * @param remark   退款描述【长度5到50】
     */
    public  static BaseVo<RefundResponseData> refund(RefundType refundType, String address, String amount, String orderCode, String remark) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));

        }
        if ( refundType == null || amount == null || remark == null || orderCode == null
                || remark.isEmpty() || orderCode.isEmpty() || amount.isEmpty()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }
        String appId = Constants.getAppId();
        String timestamp = System.currentTimeMillis() + "";
        String secertSign = AES.Encrypt(appId + timestamp,Constants.getSecret());
        Map<String,Object> map = new HashMap<>();
        map.put("refundType",refundType);
        map.put("remark",remark);
        map.put("amount",amount);
        map.put("appId",appId);
        map.put("orderCode",orderCode);
        map.put("secretSign",secertSign);
        map.put("timeStamp",timestamp);
        if (address != null && !address.isEmpty()) {
            map.put("address",address);
        }
        Call<BaseVo<RefundResponseData>> baseVoCall =  ServerApi.SERVICE_API.gotoRefund(Constants.basrUrl + "trade/refund",map);
        try {
            BaseVo<RefundResponseData> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 获取退款信息
     * @param orderCode     订单编号【长度20到50】
     */
    public  static BaseVo<RefundInfoResponseData> getRefunds(String orderCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }

        if (orderCode == null || orderCode.isEmpty() ) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);

        Call<BaseVo<RefundInfoResponseData>> baseVoCall =  ServerApi.SERVICE_API.getRefundInfo(Constants.basrUrl + "trade/getRefunds",map);
        try {
            BaseVo<RefundInfoResponseData> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     *提现
     * @param address              地址
     * @param amount               数量【最小0.000001】
     * @param coinName             币种
     * @param merchantUser     	   商家用户【长度10到20之间】
     * @param orderNo              订单号【长度10到30】
     */
    public  static BaseVo<WithdrawResponse> withdraw(String protocolName,String address,String amount,CoinNameEnum coinName,String merchantUser,String orderNo,String money,OrderTypeCodeEnum orderType,CurrencyCodeEnum currencyCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }
        if (address == null  || coinName == null || merchantUser == null || orderNo == null || protocolName == null) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }
        Map<String,Object> map = new HashMap<>();
        if (orderType == OrderTypeCodeEnum.BY_AMOUNT) {
            if (amount == null || amount.equals("")) {
                return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError3));
            }
            map.put("amount",amount);
        }
        if (orderType == OrderTypeCodeEnum.BY_MONEY) {
            if (money == null || money.equals("")) {
                return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError4));
            }
            map.put("money",money);
            map.put("currency",currencyCode);
        }
        String appId = Constants.getAppId();
        String timestamp = System.currentTimeMillis() + "";
        String secertSign = AES.Encrypt(appId + timestamp,Constants.getSecret());
        map.put("address",address);
        map.put("appId",appId);
        map.put("coinName",coinName);
        map.put("merchantUser",merchantUser);
        map.put("orderNo",orderNo);
//        map.put("feeAmount",feeAmount);
        map.put("timeStamp",timestamp);
        map.put("orderType",orderType);
        map.put("protocolName",protocolName);
        Call<BaseVo<WithdrawResponse>> baseVoCall =   ServerApi.SERVICE_API.withdraw(Constants.basrUrl + "trade/withdrawal",map);
        try {
            BaseVo<WithdrawResponse> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 获取单价汇率
     * @param coinName coinName
     * @param currencyCode currencyCodeEnum
     * @return
     */
    public  static BaseVo<CoinPriceResponse> getCoinPrice(CoinNameEnum coinName,CurrencyCodeEnum currencyCode) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999, ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }
        if (coinName == null || currencyCode == null ) {
            return new BaseVo<>(9999, ApiString.Companion.getString(ApiString.ApiDismissParameterError));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("coinName",coinName);
        map.put("currency",currencyCode);

        Call<BaseVo<CoinPriceResponse>> baseVoCall =   ServerApi.SERVICE_API.getPrice(Constants.basrUrl + "trade/getCurrencyCoinPrice",map);
        try {
            BaseVo<CoinPriceResponse> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 获取账单
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param pageSize 数量
     * @param pageNo 页数
     */
    public  static BaseVo<BillRecord> getBillRecords( LocalDateTime startTime,LocalDateTime endTime,Integer pageSize,Integer pageNo) {
        if (!Constants.getInstance().isInitAllParameters()) {
            return new BaseVo<>(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("appId",Constants.getAppId());
        map.put("pageSize",pageSize);
        map.put("pageNo",pageNo);
        if (startTime != null) {
            map.put("startTime",startTime);
        }
        if (endTime != null) {
            map.put("endTime",endTime);
        }
        Call<BaseVo<BillRecord>> baseVoCall = ServerApi.SERVICE_API.getBillRecord(Constants.basrUrl + "trade/getBill",map);
        try {
            BaseVo<BillRecord> body = baseVoCall.execute().body();
            return body;
        }catch (Exception e) {
            return new BaseVo<>(9999,e.getMessage());
        }
    }

    /**
     * 验证回调签名并组装回调对象
     * @param headerSignString header中的签名(X-Merchant-sign)
     * @param bodyString  body体内容
     * @param listener 回调结果
     */
    public  static void verifySignAndGetResult (String headerSignString,String bodyString,CallBackListener<PaymentCallBackResponse> listener,CallBackListener<UserWithdrawCallBackResponse> withdrawCalllBack,CallBackListener<MakeUpCallBackResponse> makeUpCallBackResponseCallBack) {
        if (!Constants.getInstance().isInitAllParameters()) {
            if (listener != null) {
                listener.onError(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
            }
            if (withdrawCalllBack != null) {
                withdrawCalllBack.onError(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
            }
            if (makeUpCallBackResponseCallBack != null) {
                makeUpCallBackResponseCallBack.onError(9999,ApiString.Companion.getString(ApiString.ApiParameteInitError));
            }
            return;
        }
        if (headerSignString == null || headerSignString.isEmpty() || bodyString == null || bodyString.isEmpty()) {
            if (listener != null) {
                listener.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError5));
            }
            if (withdrawCalllBack != null) {
                withdrawCalllBack.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError5));
            }
            if (makeUpCallBackResponseCallBack != null) {
                makeUpCallBackResponseCallBack.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError5));
            }
            return;
        }

        // 拼接成a=b,c=d的形式
        String signString = generateClearTextSign(bodyString);
        // 验证签名
        boolean isRight = RSAUtils.verifySign(Constants.getPublicKey(), signString, headerSignString);

        JSONObject jsonObject = new JSONObject(bodyString);
        String type = jsonObject.getString("orderType");

        if (type.equals("payment")) { /// 用户付款
            if (!isRight) { // 验签失败
                listener.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError6));
                return;
            }
            String orderCode = jsonObject.getString("orderCode");
            String coinName = jsonObject.getString("coinName");
            String address = jsonObject.getString("address");
            String amount = jsonObject.getString("amountPaid");
            String protocolName = jsonObject.getString("protocolName");
            String price = jsonObject.getString("price");
            Integer paymentStatus = jsonObject.getInt("paymentStatus");
            Boolean result = jsonObject.getBoolean("result");
            String money = jsonObject.getString("money");
            String orderNo = jsonObject.getString("orderNo");
            PaymentCallBackResponse resultResponse = new PaymentCallBackResponse(type,orderCode,coinName,address,amount,protocolName,paymentStatus,result,price,money,orderNo);
            listener.onFinish(resultResponse);
        }else if (type.equals("withdraw")) { /// 用户提币
            if (!isRight) { // 验签失败
                withdrawCalllBack.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError6));
                return;
            }
            String orderCode = jsonObject.getString("orderCode");
            String coinName = jsonObject.getString("coinName");
            String protocolName = jsonObject.getString("protocolName");
            String address = jsonObject.getString("address");
            String currency = jsonObject.getString("currency");
            String money = jsonObject.getString("money");
            String price = jsonObject.getString("price");
            String amount = jsonObject.getString("amountPaid");
            String hashId = jsonObject.getString("hashId");
            Boolean result = jsonObject.getBoolean("result");
            String orderNo = jsonObject.getString("orderNo");
            UserWithdrawCallBackResponse userWithdrawCallBackResponse =  new UserWithdrawCallBackResponse(orderCode,type,coinName,protocolName,address,amount,result,price,money,currency,hashId,orderNo);
            withdrawCalllBack.onFinish(userWithdrawCallBackResponse);
        }
        else if (type.equals("makeUp")) { /// 补单
            if (!isRight) { // 验签失败
                makeUpCallBackResponseCallBack.onError(9999,ApiString.Companion.getString(ApiString.ApiDismissParameterError6));
                return;
            }
            String orderCode = jsonObject.getString("orderCode");
            String coinName = jsonObject.getString("coinName");
            String protocolName = jsonObject.getString("protocolName");
            String price = jsonObject.getString("price");
            String address = jsonObject.getString("address");
            String money = jsonObject.getString("money");
            String amountPaid = jsonObject.getString("amountPaid");
            Integer paymentStatus = jsonObject.getInt("paymentStatus");
            Boolean result = jsonObject.getBoolean("result");
            String orderNo = jsonObject.getString("orderNo");
            MakeUpCallBackResponse make = new MakeUpCallBackResponse(orderCode,type,coinName,protocolName,price,address,amountPaid,money,result,paymentStatus,orderNo);
            makeUpCallBackResponseCallBack.onFinish(make);
        }
    }

    /**
     * 根据json串生成明文签名
     *
     * @param jsonStr
     * @return
     */
    public static String generateClearTextSign(String jsonStr) {
        JSONObject jsonObject = new  JSONObject(jsonStr);
        Map<String, Object> treeMap = new TreeMap<>();

        for (String key : jsonObject.keySet()) {
                treeMap.put(key, jsonObject.get(key));

        }

        StringBuffer sb = new StringBuffer();
        for (String key : treeMap.keySet()) {
            // 字母序降序排列拼接
            if (!(treeMap.get(key) instanceof List)) {
                sb.append(key + "=" + treeMap.get(key) + ",");
            }else {
                sb.append(key + "=" +  ((List<String>) treeMap.get(key)).get(0) + ",");
            }

        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
