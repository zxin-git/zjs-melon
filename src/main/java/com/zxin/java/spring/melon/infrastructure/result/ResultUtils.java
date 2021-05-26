package com.zxin.java.spring.melon.infrastructure.result;

import java.util.Objects;

/**
 * 默认响应
 * @author zxin
 */
public interface ResultUtils {

    String SUCCESS_CODE = "0";

    String ERROR_CODE = "1";

    String FB_ERROR_MSG = "调用接口失败，请稍后重试！";

    String SUCCESS_MSG = "success";

    /**
     * feign 异常响应
     * @param <T>
     * @return
     */
    static <T> Result<T> errorFeignResult(){
        return new Result<>(ERROR_CODE, FB_ERROR_MSG, null);
    }

    /**
     * 异常响应
     * @param msg
     * @param <T>
     * @return
     */
    static <T> Result<T> errorMsg(String msg){
        return new Result<>(ERROR_CODE, msg, null);
    }

    /**
     * 响应是否成功
     * @param result
     * @param successCode 成功 响应码
     * @param <T> result 数据
     * @return
     */
    static <T> boolean isSuccess(Result<T> result, String successCode){
        return result != null && Objects.equals(successCode, result.getCode());
    }

    /**
     * 默认响应成功码
     * @param result
     * @param <T>
     * @return
     */
    static <T> boolean isSuccess(Result<T> result){
        return isSuccess(result, SUCCESS_CODE);
    }


    /**
     * 成功
     * @param t
     * @param <T>
     * @return
     */
    static <T> Result<T> success(T t){
        return new Result<>(SUCCESS_CODE, SUCCESS_MSG, t);
    }

    /**
     * 成功
     * @param <T>
     * @return
     */
    static <T> Result<T> success(){
        return success(null);
    }

}
