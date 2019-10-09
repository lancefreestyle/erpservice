package com.capgemini.cn.core.response;

public enum DataStatus {

    /**
     * 占位符,无具体业务使用意义
     */
    PLACEHOLDER("PLACEHOLDER", "占位符,无具体业务使用意义."),

    /**
     * 成功
     */
    SUCCESS("00000", "成功"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR("10001", "系统错误"),

    /**
     * 服务暂停
     */
    SERVICE_UNAVAILABLE("10002", "服务暂停"),

    /**
     * 远程服务错误
     */
    REMOTE_SERVICE_ERROR("10003", "远程服务错误"),

    /**
     * IP限制不能请求该资源
     */
    IP_LIMIT("10004", "IP限制不能请求该资源"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR("10005", "业务异常"),

    /**
     * 不支持的MediaType：{}
     */
    UNSUPPORT_MEDIATYPE("10007", "不支持的MediaType：{}"),

    /**
     * 参数错误，请参考API文档
     */
    PARAM_ERROR("10008", "参数错误，请参考API文档"),

    /**
     * 任务过多，系统繁忙
     */
    SYSTEM_BUSY("10009", "任务过多，系统繁忙"),

    /**
     * 任务超时
     */
    JOB_EXPIRED("10010", "任务超时"),

    /**
     * RPC错误
     */
    RPC_ERROR("10011", "RPC错误"),

    /**
     * 非法请求
     */
    ILLEGAL_REQUEST("10012", "非法请求"),

    /**
     * 不合法的用户
     */
    INVALID_USER("10013", "不合法的用户"),

    /**
     * 接口访问权限受限
     */
    INSUFFICIENT_PERMISSIONS("10014", "接口访问权限受限"),

    /**
     * 缺失必选参数{}，请参考API文档
     */
    MISS_REQUIRED_PARAMETER("10016", "缺失必选参数{}，请参考API文档"),

    /**
     * 参数值非法，需为{}，实际为{}，请参考API文档
     */
    PARAMETER_VALUE_INVALID("10017", "参数值非法，需为{}，实际为{}，请参考API文档"),

    /**
     * 请求长度超过限制
     */
    REQUEST_BODY_LENGTH_OVER_LIMIT("10018", "请求长度超过限制"),

    /**
     * 接口不存在
     */
    REQUEST_API_NOT_FOUND("10020", "接口不存在"),

    /**
     * 请求的HTTP METHOD不支持，请检查是否选择了正确的POST/GET方式
     */
    HTTP_METHOD_IS_NOT_SUPORTED("10021", "请求的HTTP METHOD不支持，请检查是否选择了正确的POST/GET方式"),

    /**
     * IP请求频次超过上限
     */
    IP_REQUESTS_OUT_OF_RATE_LIMIT("10022", "IP请求频次超过上限"),

    /**
     * 用户请求频次超过上限
     */
    USER_REQUESTS_OUT_OF_RATE_LIMIT("10023", "用户请求频次超过上限"),

    /**
     * 用户请求特殊接口{}频次超过上限
     */
    USER_REQUESTS_FOR_OUT_OF_RATE_LIMIT("10024", "用户请求特殊接口{}频次超过上限");

    private String code;
    private String msg;

    DataStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

//    /**
//     * 根据传入的数值获得相应的枚举值
//     *
//     * @param sourceCode 需要传入的数值
//     * @return 返回数值对应的枚举值对象
//     * @throws SmiBusinessException 如果传入的数值为空或者无法匹配的合法的枚举值则抛出异常
//     */
//    public static DataStatus getCodeEnum(Integer sourceCode) throws SmiBusinessException {
//        DataStatus result = null;
//
//        if (null == sourceCode)
//            throw new SmiBusinessException("参数sourceCode不能为NULL!");
//
//        for (DataStatus enumObj : DataStatus.values()) {
//            if (enumObj.code().equals(sourceCode))
//                result = enumObj;
//        }
//
//        if (null == result) {
//            throw new SmiBusinessException("无法匹配到合法的枚举值!");
//        } else if (PLACEHOLDER.equals(result)) {
//            throw new SmiBusinessException("不能使用占位符枚举值!");
//        }
//        return result;
//    }
}
