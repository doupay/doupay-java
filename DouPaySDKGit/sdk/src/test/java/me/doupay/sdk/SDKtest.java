package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class SDKtest {


    public  static  void  initAllParameters() {
        String timeStamp = "1610697341483";
        String appId = "doupay_JEPwPEB2MD";
        String secret = "000d5f84f5a49bc3305fc18bb265afc5";
        String privateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCPxHn5ySq3Mq8o\n" +
                "MU0QO7Zw7LIzhRdvxdUiuCInlvXntuNbi5XL7WKD8fA2kp1b07BnLMgej+6DuF0V\n" +
                "OMHkDDf3zb+uHqRsf8zpX5VwqxQMTYu0K3P69FJ6aSdJNLxF4JvslwRbZW7Ncv9l\n" +
                "1Z1XaDrZfClqQaDUZnsp21XAjlvqKHYnKngvyIlDQcpV4vDOp7TkNTQjUwchIiTm\n" +
                "d4cao4YYYqwhAsTJYcYkPWLgqPjaVkPlWwnYeLB3p6IokMQz44KFnkhdoYCj3wB3\n" +
                "vmeX6AIJad0+6LrABYOA1d9BZimv5AXzSKmT8tnfSQsoA0a3gIKI+npqL9ErejfB\n" +
                "GVUezbW1AgMBAAECggEALkconGdNALun9mAoVlliWOdYVY06BhjAivSKygOmFHii\n" +
                "pw0/ou0/EQoIMQjw7mYuGognwu7B8FSgYfxrLWVhfrsUQJBMjUB2TYkfKa1oPq2X\n" +
                "kt+J7fZHtm+y3bXEBRpQFtBl7qWwDSI/ZCBnDYPXrbpx+mo1wylZ7BdWey1YGP9+\n" +
                "m/dFrqiFZwwXef7GyBMDPr37c0gjXblqkwVz3rNR6qCc3MQi+zXwyhbJAuSAVBab\n" +
                "RcODWZqD1S0ZLw5L0BOWvGJnB2+BAdWQ+BaAJmtRLBTcEvRbvdL1VBX/L+vyAVRe\n" +
                "c8J6Cjt1KyAEDa/18bL3ih5SLgHdwT7YIiEJdv0P4QKBgQDwe6kTlGiD70kAEmgo\n" +
                "VvOMpqivP1SDhrbQScbzzFGLfiMA4HbhyuZoDw8304/otSW5CkEkaJ19L2DglNno\n" +
                "Rv9q8C7xY3g0BjuOeQNx5P484k6L6GyRRYRhWS8POVEMXGqnyLNgfPZs8NDohaKm\n" +
                "G/IFT24WjwufVipDFnjyPqAdKwKBgQCZC0CGBw8BvcVbCHnmYdbGQ/D4ZoX1BMLL\n" +
                "xcEXrDTY8NA6L4uZOJ8kOQIOZGcsY25LBXFaEKWL0rOBdCtq2M18pPQzbHE67lRK\n" +
                "gw6K8r/vAGVKcokvwyLUmXxyLjJoylHb4iZyY4P03Fl3zSQaOpAHBEcF1H2oItLN\n" +
                "iA1EMrbInwKBgQDc4ni2R0aIiK0gp8eL5fHmat3duenCtWYNgvZ+0FjGK6GzGHmZ\n" +
                "g2iGg+6SdHxmXpy7jbOv4XdmmLH/Fjngo/XPH7W+eoLaJi9l+bk0UAVFnwhOcbnm\n" +
                "5Vdmoygab6cGF4zPeAVqxt0By1/Xc4el011Fi2OuzMz8GYTQAkAtIWCn6QKBgGPI\n" +
                "zFcWvxgZjVXfXutxG0HGBpVO80RfyEpoM4+lvgc8a+ekHFbYbhqF+Os9V2+/nKfZ\n" +
                "cqCQff9+b3+WKMDPfpsoSfhFWkZcIiU68f5ya+X+0gwKRZwYlNsc/+DKch+U2m6N\n" +
                "Mxgd/mlmSgcsf7+CM2n/xfbtJsi7e8p6THwMvNRtAoGBANPQjWcXbVeSUpVONYOu\n" +
                "j1vTFIDx2yamETbA556r2hipkFfLdAYGiVkPlgCPOwOuQgM+fy+ymSXMR98JreWe\n" +
                "WjoRUd3nh9VueSNXUty2qvlF1QEdcYfFJW/Q5agbwgZaoMTbefbroZou0MNjaVW8\n" +
                "cFg70chkOBG0fvyiKS/6A81w";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8EDijmSxmDT2rvH8+HYo5uLbSmiNvUfPE2/LFYt9Tt183uEDa6bnlCDGQIa1srhhVJACXiUXSL4/QmcE+vF6odzloVjG9kT/jZpa9wv6MEvyDJXzIBCxVRNJ9MrcTbM3alsf3dCIqUIgNziZTYCheiF7uPB3nRPmLTLFp12WCEtM4kqKBBMq1jX3hfEqFwg5iVryHDRdxQJNI6KzIYT0haL5RANhBon7IFArajPYieaeSE+hqkwqsP6G+qTSng6SfLdCw324up/KP9dFB/7kQchiYvcMvUeD8IL2J7NemhM6vQ5Rx+g/Y9bPDvnZ0kWSZBBAdHyJf7kIwboapE05NQIDAQAB";

        Constants.openSysLog = true;
        Constants.getInstance().init(secret,privateKey,publicKey,appId,"200");
    }

    @Test
    public void getCoinList () {
        initAllParameters();
        PaymentInfo.getCoinList(new CallBackListener<CoinResponseData>() {
            @Override
            public void onFinish(CoinResponseData data) {
                System.out.println("-------------------------" + data.toString());

            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);

            }
        });
    }
    @Test
    public void getCurrencyList() {
        initAllParameters();
        PaymentInfo.getCurrencyList(new CallBackListener<CurrencyResponseData>() {
            @Override
            public void onFinish(CurrencyResponseData data) {
                System.out.println("-------------------------" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }


    @Test
    public void getPay() {
                 initAllParameters();
                String orderNo = String.valueOf(System.currentTimeMillis());
                PaymentInfo.pay("5", CoinCodeEnum.USDT, CurrencyCodeEnum.CNY, "17701278888", orderNo,
                "我很好啊啊", "", "", OrderTypeCodeEnum.CountBuy, new CallBackListener<PayResponseData>() {
                    @Override
                    public void onFinish(PayResponseData data) {
                        System.out.println("++++++++++++++++" + data.toString());
                    }

                    @Override
                    public void onError(int errorCode, String msg) {
                        System.out.println(errorCode + "-------------------------" + msg);
                    }
                });
    }

    @Test
    public void cancle() {
        initAllParameters();
        PaymentInfo.cancleOrder("ZF202107031430314990720038", new CallBackListener<PayResponseData>() {
            @Override
            public void onFinish(PayResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getOrderInfo() {
        initAllParameters();
        PaymentInfo.getOrderInfo("ZF202107061802551623157444", new CallBackListener<OrderInfoResponseData>() {
            @Override
            public void onFinish(OrderInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getPaymentInfo() {
        initAllParameters();

        PaymentInfo.getPaymentInfo("0001","" ,"ZF202107031353384554486189", new CallBackListener<PaymentInfoResponseData>() {
            @Override
            public void onFinish(PaymentInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());

            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getRefund() {
        initAllParameters();
        PaymentInfo.refund("TEQrvHyU54YibVHMGb7475n8y3mXBofaaR", "0.5", "ZF202107051115409252689736", "退0.5个,啦啦啦", new CallBackListener<RefundResponseData>() {
            @Override
            public void onFinish(RefundResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getRefundInfo() {
        initAllParameters();
        PaymentInfo.getRefunds("ZF202107051115409252689736", new CallBackListener<RefundInfoResponseData>() {
            @Override
            public void onFinish(RefundInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void withdraw() {
        initAllParameters();
        String orderNo = String.valueOf(System.currentTimeMillis());
        PaymentInfo.withdraw("TEQrvHyU54YibVHMGb7475n8y3mXBofaaR", "50", "0003", orderNo, orderNo, new CallBackListener<WithdrawResponse>() {
            @Override
            public void onFinish(WithdrawResponse data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
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
        });
    }

    @Test
    public void  getBillRecord () {
        initAllParameters();
        LocalDateTime start =  LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();
        PaymentInfo.getBillRecords( null, null, 10, 1, new CallBackListener<BillRecord>() {
            @Override
            public void onFinish(BillRecord data) {

            }

            @Override
            public void onError(int errorCode, String msg) {

            }
        });
    }



}