package me.doupay.sdk.bean;

import java.util.List;

public class CoinChainCodeResp {


    private List<RecordsBean> records;

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * protocolCode : 0006
         * protocolName : TRC20
         * chainCoinName : USDT
         * chainCoinCode : 0006
         */

        private String protocolCode;
        private String protocolName;
        private String chainCoinName;
        private String chainCoinCode;

        public String getProtocolCode() {
            return protocolCode;
        }

        public void setProtocolCode(String protocolCode) {
            this.protocolCode = protocolCode;
        }

        public String getProtocolName() {
            return protocolName;
        }

        public void setProtocolName(String protocolName) {
            this.protocolName = protocolName;
        }

        public String getChainCoinName() {
            return chainCoinName;
        }

        public void setChainCoinName(String chainCoinName) {
            this.chainCoinName = chainCoinName;
        }

        public String getChainCoinCode() {
            return chainCoinCode;
        }

        public void setChainCoinCode(String chainCoinCode) {
            this.chainCoinCode = chainCoinCode;
        }

        @Override
        public String toString() {
            return "RecordsBean{" +
                    "protocolCode='" + protocolCode + '\'' +
                    ", protocolName='" + protocolName + '\'' +
                    ", chainCoinName='" + chainCoinName + '\'' +
                    ", chainCoinCode='" + chainCoinCode + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CoinChainCodeResp{" +
                "records=" + records +
                '}';
    }
}
