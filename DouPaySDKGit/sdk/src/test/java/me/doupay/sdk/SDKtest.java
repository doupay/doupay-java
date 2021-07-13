package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import me.doupay.sdk.net.BaseVo;
import org.junit.Test;

import java.time.LocalDateTime;


public class SDKtest {


    public  static  void  initAllParameters() {
        String timeStamp = "1610697341483";
        String appId = "doupay_o76brkqV3P";
        String secret = "0b58f06939be1aaa165e5a2c7a61c85f";
        String privateKey="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNaXhuqmytUtjb\n" +
                "dP5XoyZIWXXV5LsUsl9xPbR7Ckax3XqH2L85MGZiFw0ae2TJeQ3YiAmHIi05Qhvj\n" +
                "BConl4gD8tu5IfjDh2IrEEZWd1sSzPkc9KIgT+4K+HnsCeANQyQOg09Q6kW3d8B4\n" +
                "LDG0qRE6RIQF6TFoA7VdERIT/0hDhdQVn3ks0FdZwhwWpbwxM7Mq0/YskZJc2Wi3\n" +
                "Ujdy7mtkOB0UtvW0JN0NcNQLdoD73+1kF7HTS6nxrJdRk5mp1GAL/RfEJbpNqf2u\n" +
                "NgKDInzBKGw8IbURlYS+BMWCq4+dXbr1+GhKs6hdWdiy+MooUV8M+6MrjkAcaU7/\n" +
                "EiC+y3WTAgMBAAECggEAXsUtafUbKjlYjhLlFbSIRnp15ygIXMGCBzFUUBU99Zu5\n" +
                "r2sKFHikVN6f8Hx7ui4/ojrhL8guyK3OZKD441nBVOwgZv0ma1vC5ZtdmDsbNQlb\n" +
                "dhVYxhDrNjz58L9ZgWnas0M7F745hNBjk+YCVdHscsFSPWffrZa2qC11kSNHub/p\n" +
                "N+BPDbXN0Hhp+Zru42EqeAbSdGLmlAu4tNx9LyVBUIB/n2LZAMN2s6ywmeEDbwQq\n" +
                "WP/7D87LYWQU/3VtYqRxxJZP/whxcFq1MJrKc4HSd1DQ4yZBKJ8cdiesg2c9cnCR\n" +
                "gTnEaobjgEOGmkBw38dkeZXNucflefgNAwtllcYugQKBgQDT14icxHPim23oPqvj\n" +
                "SeotQ/n6pGrEqw7r1bffPdmW4Ue0jTKDU2hMxvW5b8i7Uf3VhXDoGhUFELImHILU\n" +
                "Dmxip1htw/XsgD/Gz6zWXjzQcDFsjf95TCZb7JIFJNGgqUkB58JH7roAeuCBPus+\n" +
                "5i2jjS7dy5ZIxM0ccLAJPuZhQQKBgQCq45oxRE5UhWevYbgV6nmjsNvqM7o1zlx6\n" +
                "uKTUfOY+sX/ZwGJ+HnlK3fKYbYSmMc8/Qj5iiMu0bDjS7tzhX9OneQ3+9/6zXWYs\n" +
                "AjmJChP1Y6NfvIwReTSiLkHK8HduHnAI50HKpzQrX0nZv4oZ9zX1BbMj/+K1JaZV\n" +
                "Z7Us7LkN0wKBgBQ7SmXGcVbcB0Qd8CaV4ZKPImmomDXOLG+jipr8ejJps4Jv1bor\n" +
                "FhP3EHK0VVRmgTqKMv1HuGgybwEqyefctMc7OjvJckwy92RSYyxZ9a7meCHo8dQw\n" +
                "zJ0M2+k32flhEYLoEmryRrtTAOv3CVqJeyRakHZIQkMS4I/txzIq2q/BAoGAAdaa\n" +
                "9Qa4FP6uY9uYQFwaXOFtLDLMQQHsSsGrvEFvtKLyLiR8qsCnK2AB2RPshmEoypRq\n" +
                "2WKBVnqHjfVV2PLP8xBBT0nZqpJJpBWOCuRZ3Jzqx//ePd3g7BG1UXqOvleDewUJ\n" +
                "1yU/UWwf/kCqOqdHJFCgYbXB+ZLjHC4Wa9pMD1MCgYA9sgdnQ60ipPYcqDiVZuw1\n" +
                "kDC+zq7l0Z4mfoPNJ8UKA9y2pJ/8BHLSxKXCtXmLvkBHOVmRmwidhBkVJnYZTPhZ\n" +
                "OFhiCGStVHZbl4oBSB3djCGaV6qNzK2ZTc/6iyJvf1Mm1wLIL/sPx7Syuliol8Mx\n" +
                "xz2b3uLpFk3p8R/krzdNJQ==";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2BXDlBjD/ySSWxg3Av/fwpyVGbwTG44aEWzQLvvjNxKTNmTtdlSd1Y0d0+4zY8t4H3ND4au969FEkeuqIJBdUroOHvfS4QNlr1TMIfCezB12j2i1lAHx7UEyusfoA8NkIYpv2BB57jW9mi10hiakAgD672shxdgSdT8VKoKz4rsTHHJVoDdPcrJXUOIFky8gb6KR+qP1jMDMHxlCb/HVGT4JUbwXcSsYr6zXitXzO5eyEzAYhiK3j3RG9HxYT/AcleLo/Grl+ZrJ0Swzas1DvKnqUjYHCvLrjtmrWuQ2RX3DZWE3CQQVifL4ZB+KHAi8ceRz3mbfdmT7Yx3bBUWBUQIDAQAB";
        Constants.openSysLog = true;
        Constants.getInstance().init(secret,privateKey,publicKey,appId,"86400");
        Constants.setBasrUrl("http://192.168.10.126:9000/");
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

        BaseVo<PayResponseData> baseVo = PaymentInfo.pay("10", CoinNameEnum.TRX, CurrencyCodeEnum.CNY, "17701278888", orderNo,
                "我很好啊啊", "", "", OrderTypeCodeEnum.BY_AMOUNT);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void cancle() {
        initAllParameters();

        BaseVo<PayResponseData> baseVo =  PaymentInfo.cancleOrder("ZF202107121428241334279126");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getOrderInfo() {
        initAllParameters();
        BaseVo<OrderInfoResponseData> baseVo = PaymentInfo.getOrderInfo("ZF202107132020338506462587");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getPaymentInfo() {
        initAllParameters();

        BaseVo<PaymentInfoResponseData> baseVo =  PaymentInfo.getPaymentInfo("0001","" ,"ZF202107031353384554486189");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getRefund() {
        initAllParameters();
        BaseVo<RefundResponseData> baseVo = PaymentInfo.refund("", "1", "ZF202107132020338506462587", "退0.5个,啦啦啦");
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void getRefundInfo() {
        initAllParameters();

        BaseVo<RefundInfoResponseData> baseVo = PaymentInfo.getRefunds("ZF202107132020338506462587");
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
        BaseVo<WithdrawResponse> baseVo = PaymentInfo.withdraw("TEQrvHyU54YibVHMGb7475n8y3mXBofaaR", "0.07", CoinNameEnum.USDT, orderNo, orderNo);
        if (baseVo.getCode() == 200) {
            System.out.println("-------------------------" + baseVo.getData().toString());
        }else {
            System.out.println(baseVo.getCode() + "-------------------------" + baseVo.getMsg());
        }
    }

    @Test
    public void makeup() {
        initAllParameters();
        BaseVo<MakeUpResponse> baseVo = PaymentInfo.maleUp("ZF202107132020338506462587");
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