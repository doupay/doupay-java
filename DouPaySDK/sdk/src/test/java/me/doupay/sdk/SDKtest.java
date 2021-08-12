package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.enums.RefundType;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import me.doupay.sdk.net.BaseVo;
import me.doupay.sdk.net.Language;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Random;


public class SDKtest {


    public  static  void  initAllParameters() {
        String appId = "doupay_n62mewaVa9";
        String secret = "cff7d04980ff1a720c8e8f61c73d4073";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC2i06su2Hctp/L\n" +
                "cI0fsTUtO69J8LOoFI9xp3msU0LrcGbw3hXkL4kSxqCbwREmhkHD45/PFl84XVVC\n" +
                "Q9Fkkpln9fxIqnL2zLdaSy6rI+fbg/l7Rpz2HamzocYw9AXAUoVtkDajYJC/SmqT\n" +
                "fTeq18zx5eSQD3syPlMUQFRlq5lnYF0TLmtZbhlVu9XPsTkE0yOd4n2TpOr6ZXDH\n" +
                "rz1dzWwN2REFBV4aUXQGjR4BEyv67V6WuO4fJXHGM6ovBlH+sIyJ0g3glsN8tLBA\n" +
                "XssLYHkbwX319jJa6alQldFCWz+HanbHn1SRK1rZBSt9a7wc2b5cgo4RI69eF9XE\n" +
                "PWKG/zzPAgMBAAECggEBAI6r9sO+eNBe1CnXQBWjFSLTYT9zJ5eY6jw0Xz62nLkT\n" +
                "UwGzMnz0Qjgwklrp3RO1HzWRdNgQbj/JgteV1dS7V7cPZS0OO2h1vGCQHluYZqEF\n" +
                "VzpoiEk8CeTh7dtY/h3A4ZQugOXUlY1NBltcJOQcYow12BxYXTt5xskvNkd4hR9r\n" +
                "uFhINtksfKvq/jdHJVis5t+4phUdeyYeE4CwFGGeBgwxMu/LkGNGU/zUQ1Kl7PZN\n" +
                "TyEKm5uhzglV8nKvRc04FGOJcHi2jU98/nqBGnnrybqHaGfPO9BdmaVc9t5KI0Dq\n" +
                "LrQKyGlT4UowUYW/6BU5KVuICfYZUXIrr7SMYakzc+ECgYEA7BbbC+EbmYJDuAMu\n" +
                "HA5sDBV2y5ZIZ/+ljLFvL2tA8jFb2qbdgPQVkTX8TgUvA3oisq7i5Maps+KE/y1Z\n" +
                "8Oaz4kg+nRiZQ3ms5JYHhAKZdFcm1Cf3n0ge09t6J/HqYClVdQfqOgmKjYJZ8CCN\n" +
                "YsVIduK65EAVDo/YfMWYYxHllwcCgYEAxfBrAdLER/zu3V1+ONyFx+8ZVOafkk4O\n" +
                "wkwwanWPd2a5NgDDaoY/xJylkBEdqlstLpkC4k0cdt/LRts9w63LDu9P6Na/r726\n" +
                "jIZokK1yAcSHTATVKgfR6STo0nNFWn/Uk5CpBD0jgLsq6yB8wwLRVCqyaj5GGLoH\n" +
                "zVfyGoxBMfkCgYAzPJaXUmhZ/WJS+iW0oxCh4rqgXmIiZ+H20b8ujFlQ9pNXtaUW\n" +
                "ymIv3IaALDHS0FvdaYUGX3MO/hcdBiuh03+wmTs1ftQsR6jVBxZkeOfyzsM3geEE\n" +
                "qXM/ST+Okbrq2a2ZM3mK1O1D3slECtyEVgpu+q/Sv3GScndqRLvYrFamWwKBgBmf\n" +
                "ufqOcmJvV+zIQaLSyW7MgRcAk/+4oyh7/HiLp3rpjWh0SNftcSveq4Au9wwqqXqy\n" +
                "zDDHkrvA1OvjTeebBAJ28H1P75iskw3GCJtSGMQp0OoCZiX+xSnNYWZ9DaldiwNf\n" +
                "YsHtuD7d+/xcREpqfvbKYDZowWJKEuB+VhUhuv7hAoGAZssteG/Nsv8xxI36A5qK\n" +
                "sQkFM+OX3RtbtOsBN07/ynEcKqs03u1c53Q81xdVTmCLvC87cGYv14sPzbReSB3K\n" +
                "BU3AY9JVRJGpuQkAhY85gj6LLCqpzw2GGfNQK875tJy7VyKcMtOQ5XOmdAYLTi4q\n" +
                "QYbWcXx9Zv1w2ezKZE8EFG8=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhl7C2UAO1DZYOYLK+6IN5zez+WOFpGiAeGjToLXVkPtVKY0iKR+sZIXvx1FdszQOaIDkPlHgbisi5HYoWayQ8Hj2+NylQ1pBz+xek/fl9DKpIb3jKrlZBI4jnkNNQTx2guGVM9BbnQBE52OMf4hB3OfCFpPDyuc5tEE10rZtYRNYbdGeR4xgm0esZYyS6CfwZ275mbcTxnHsa09xghsL5qQi+bwDvSOp9SKiCx4p79rtxhgQrBVCCFxP39E/RhSSeCh9iWwCL6kMEQYNEJHGWWCV1WDnJHIjjwIzoN/vSKXxFdjw1tigq8owNd0v3cffMOnYBLNiYtsFhswGB0t9CQIDAQAB";
        Constants.openSysLog = true;
        Constants.getInstance().init(secret,privateKey,publicKey,appId,"7200");
        Constants.setBasrUrl("http://192.168.11.113:9000/");
        Constants.setLanguage(Language.zh_CH);
    }

    @Test
    public void getCoinList () {
        initAllParameters();

        BaseVo<CoinResponseData> baseVo = PaymentInfo.getCoinList();
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }


    }
    @Test
    public void getCurrencyList() {
        initAllParameters();

        BaseVo<CurrencyResponseData> baseVo = PaymentInfo.getCurrencyList();
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getPay() {
        initAllParameters();
        String orderNo = "SJDD" + String.valueOf(System.currentTimeMillis());

        BaseVo<PayResponseData> baseVo = PaymentInfo.pay("","10", CoinNameEnum.BTC, CurrencyCodeEnum.USD, "17788888888", orderNo,
                "我要买买买", "", "", OrderTypeCodeEnum.BY_AMOUNT);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void cancle() {
        initAllParameters();

        BaseVo<PayResponseData> baseVo =  PaymentInfo.cancleOrder("ZF2021072611592641684287991");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getOrderInfo() {
        initAllParameters();
        BaseVo<OrderInfoResponseData> baseVo = PaymentInfo.getOrderInfo("ZF202108120801011894540370");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getPaymentInfo() {
        initAllParameters();

        BaseVo<PaymentInfoResponseData> baseVo =  PaymentInfo.getPaymentInfo(CoinNameEnum.USDT,"0004" ,"ZF202107280739365664124421");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getRefund() {
        initAllParameters();
        BaseVo<RefundResponseData> baseVo = PaymentInfo.refund(RefundType.NEW_ADDRESS,"TEQrvHyU54YibVHMGb7475n8y3mXBofaaR", "15.8", "ZF202107291547355277965323", "退1个,啦啦啦");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getRefundInfo() {
        initAllParameters();

        BaseVo<RefundInfoResponseData> baseVo = PaymentInfo.getRefunds("ZF202107280739365664124421");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getCoinChainCodes() {
        initAllParameters();

        BaseVo<CoinChainCodeResp> baseVo = PaymentInfo.getCoinChainCodes(CoinNameEnum.USDT);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void withdraw() {
        initAllParameters();
        String orderNo = "SHYH" + String.valueOf(System.currentTimeMillis());
        BaseVo<WithdrawResponse> baseVo = PaymentInfo.withdraw("ERC20","0x5e725D789ab3552c6D0f60ee0057b5626629D4C5", "5", CoinNameEnum.USDT, orderNo, orderNo,"500",OrderTypeCodeEnum.BY_AMOUNT,CurrencyCodeEnum.CNY);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void makeup() {
        initAllParameters();
        BaseVo<MakeUpResponse> baseVo = PaymentInfo.maleUp("需要补单","ZF202107281302375977458662");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getCallBack() {
        initAllParameters();
        BaseVo<PaymentCallBackResponse> baseVo = PaymentInfo.getCallback("ZF202107221114581046391184");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getPrice() {
        initAllParameters();
        BaseVo<CoinPriceResponse> baseVo = PaymentInfo.getCoinPrice(CoinNameEnum.USDT,CurrencyCodeEnum.CNY);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void verifySignAndGetResult () {
        initAllParameters();

        String bodystring = "{\"address\":\"TQ1EgPhuDXLvDfycCBQadbfbLkBPhEDoZX\",\"amountPaid\":\"15.26717557\",\"coinName\":\"USDT\",\"orderCode\":\"ZF202106221133335640422688\",\"paymentStatus\":1,\"protocolName\":\"TRC20\",\"result\":true}";
        String headstring = "uCJasnGz3H+2Xi86zeRkoDVEaXpM0LsCInOW1Kk28pn/3bXMn/2vUac7aQrWUzcf8YjTiXJt03IzS6k0y04TsvL1rdOj7TZgrk2aav8wM79ECviDW1+OQWd2XRhCRJGL4ca5lnXiE+1eHV5Tdq68Nu50tOkTKGI6cD3LT6imEWq5bTB0I+xuabnhSDfhWdmogmzEwKju3xSPcjxtzHGJ/c8Zc1NYH7ID92qWi77Wm6/UskHiATgULXYCbLHL/hBFDn4kGH8E+FQ0oSoPOTLOvpKnI27v6xD7CyHhMUOYRaVm5u/X4YNta65hF//JVPLnMw8I9NJA9WklDPFZ1DvIQQ==";
        PaymentInfo.verifySignAndGetResult(headstring, bodystring, new CallBackListener<PaymentCallBackResponse>() {
            @Override
            public void onFinish(PaymentCallBackResponse data) {
                System.out.println("PaymentResultResponse = " + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println("errorCode=" + errorCode + "msg =" + msg);

            }
        }, new CallBackListener<UserWithdrawCallBackResponse>() {
            @Override
            public void onFinish(UserWithdrawCallBackResponse data) {
                System.out.println("UserWithdrawCallBackResponse = " + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println("errorCode=" + errorCode + "msg =" + msg);
            }
        }, new CallBackListener<MakeUpCallBackResponse>() {
            @Override
            public void onFinish(MakeUpCallBackResponse data) {
                System.out.println("UserWithdrawCallBackResponse = " + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println("errorCode=" + errorCode + "msg =" + msg);
            }
        });
    }

    @Test
    public void  getBillRecord () {
        initAllParameters();
        LocalDateTime start =  LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();
//        PaymentInfo.getBillRecords( null, null, 10, 1, new CallBackListener<BillRecord>() {
//            @Override
//            public void onFinish(BillRecord data) {
//
//            }
//
//            @Override
//            public void onError(int errorCode, String msg) {
//
//            }
//        });
    }


}
