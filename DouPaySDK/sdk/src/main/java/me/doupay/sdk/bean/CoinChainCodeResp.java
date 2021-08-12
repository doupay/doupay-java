package me.doupay.sdk.bean;

public class CoinChainCodeResp {

    /// 链币种代码
    private String chainCoinCode;
    /// 链币种名称
    private String chainCoinName;
    /// 协议代码
    private String protocolCode;
    /// 协议名称
    private String protocolName;

    public String getChainCoinCode() {
        return chainCoinCode;
    }

    public void setChainCoinCode(String chainCoinCode) {
        this.chainCoinCode = chainCoinCode;
    }

    public String getChainCoinName() {
        return chainCoinName;
    }

    public void setChainCoinName(String chainCoinName) {
        this.chainCoinName = chainCoinName;
    }

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

    @Override
    public String toString() {
        return "CoinChainCodeResp{" +
                "chainCoinCode='" + chainCoinCode + '\'' +
                ", chainCoinName='" + chainCoinName + '\'' +
                ", protocolCode='" + protocolCode + '\'' +
                ", protocolName='" + protocolName + '\'' +
                '}';
    }
}
