package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.net.BaseVo;
import org.junit.Test;

public class SimpleSDKTest {

    public  static  void  initAllParameters() {

        Constants.setBasrUrl("http://192.168.11.113:9000/");
        Constants.openSysLog = true;
    }
    @Test
    public void cancle() {
        initAllParameters();
        BaseVo<PayResponseData> baseVo =  GetPaymentInfo.cancleOrder("ZF202108131023134048733642");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getOrderInfo() {
        initAllParameters();
        BaseVo<OrderInfoResponseData> baseVo = GetPaymentInfo.getOrderInfo("ZF202108180540250532839870");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getPaymentInfo() {
        initAllParameters();
        BaseVo<PaymentInfoResponseData> baseVo =  GetPaymentInfo.getPaymentInfo(CoinNameEnum.USDT,"0004" ,"ZF202108130826005085856666");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getCallBack() {
        initAllParameters();
        BaseVo<PaymentCallBackResponse> baseVo = GetPaymentInfo.getCallback("ZF202107221114581046391184");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

}
