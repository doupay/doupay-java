package me.doupay.sdk.net.exception

import me.doupay.sdk.Constants
import me.doupay.sdk.net.Language

enum class ApiString(var us: String,
                     var cn: String) {

    ApiParameteInitError("Please call Constants.getInstance().init() first","请先调用Constants.getInstance().init()"),
    ApiDismissParameterError("Missing required parameters", "缺少必要参数"),
    ApiDismissParameterError1("currencyCode and money parameters cannot be empty", "currencyCode和money不能为空"),
    ApiDismissParameterError2("The coinName and amount parameters cannot be empty", "coinName和amount参数不能为空"),
    ApiDismissParameterError3("The amount parameter is missing", "缺少amount参数"),
    ApiDismissParameterError4("The money parameter is missing", "缺少money参数"),
    ApiDismissParameterError5("Please pass in the signature and body", "请传入签名和body体"),
    ApiDismissParameterError6("Failed to verify signature", "验证签名失败"),
    ApiDismissParameterError7("orderType parameter is \"BY_AMOUNT\" or \"BY_MONEY\"", "orderType订单类型【BY_AMOUNT、BY_MONEY】"),
    ApiDismissParameterError8("expireTime is greater than 1800 seconds and less than 7200 seconds", "expireTime大于1800秒小于7200秒");

    companion object {
        fun getString(str: ApiString): String {
            return when (Constants.language) {
                Language.en_US -> str.us
                Language.zh_CH -> str.cn
                else -> str.us
            }
        }
    }
}