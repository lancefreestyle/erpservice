package com.capgemini.cn.core.commons;

import com.capgemini.cn.core.exception.CpmBusinessException;
import com.capgemini.cn.core.exception.NoLoginException;
import com.capgemini.cn.core.response.BizDataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BaseController {

    /**
     * 系统业务异常统一处理函数
     *
     * @param e
     */
    @ExceptionHandler(value = CpmBusinessException.class)
    public BizDataResponse<String> exceptionHandler(CpmBusinessException e) {
        final String logMsg = "业务异常返回值类型：" + e.getExceptionType().name() + "\n" + DataStatus.BUSINESS_ERROR.msg();
        log.warn(logMsg, e);
//        if (ExceptionTypeEnum.NORMAL.equals(e.getExceptionType())) {
//            return new BaseResponse<>(DataStatus.BUSINESS_ERROR, e.getMessage(), null);
//        } else {
//            return new BizDataResponse<>(DataStatus.BUSINESS_ERROR, e.getMessage(), null);
//        }
        return new BizDataResponse<>(DataStatus.BUSINESS_ERROR, e.getMessage(), null);
    }

    /**
     * 系统未知异常统一处理函数
     *
     * @param e
     */
    @ExceptionHandler(value = RuntimeException.class)
    public BizDataResponse<String> exceptionHandler(RuntimeException e) {
        log.error(DataStatus.SYSTEM_ERROR.msg(), e);
//        return new BaseResponse<>(DataStatus.SYSTEM_ERROR, DataStatus.SYSTEM_ERROR.msg(), null);
        return new BizDataResponse<>(DataStatus.SYSTEM_ERROR, DataStatus.SYSTEM_ERROR.msg(), null);
    }

    /**
     * 请求参数缺失异常统一处理函数
     *
     * @param e
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public BizDataResponse<String> exceptionHandler(MissingServletRequestParameterException e) {
        final String message = StringUtil.replacePlaceHolder(DataStatus.MISS_REQUIRED_PARAMETER.msg(), e.getParameterName());
        log.warn(message);
//        return new BaseResponse<>(DataStatus.MISS_REQUIRED_PARAMETER, message, null);
        return new BizDataResponse<>(DataStatus.MISS_REQUIRED_PARAMETER, message, null);
    }

    /**
     * 方法参数验证不合法异常处理
     *
     * @param e
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BizDataResponse<String> exceptionHandler(MethodArgumentNotValidException e) {
        String field = e.getBindingResult().getFieldError().getField();
        String fieldErrorMsg = e.getBindingResult().getFieldError().getDefaultMessage();
        String objectName = e.getBindingResult().getObjectName();
        String errorMsg = "参数{}的属性{}的值{}";
        errorMsg = StringUtil.replacePlaceHolder(errorMsg, objectName, field, (ObjectUtils.isEmpty(fieldErrorMsg) ? "不合法!" : fieldErrorMsg));
        log.warn(errorMsg);
//        return new BaseResponse<>(DataStatus.PARAM_ERROR, errorMsg, null);
        return new BizDataResponse<>(DataStatus.PARAM_ERROR, errorMsg, null);
    }

    /**
     * 客户端未登录异常统一处理函数
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NoLoginException.class)
    public BizDataResponse<String> exceptionHandler(NoLoginException e) {
        log.warn(e.getMessage(), e);
        return new BizDataResponse<>(DataStatus.INVALID_USER, e.getMessage(), null);
    }

}
