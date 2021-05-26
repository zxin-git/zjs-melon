package com.zxin.java.spring.melon.infrastructure.result;

import com.zxin.java.spring.melon.infrastructure.exception.BusExceptionEnum;
import com.zxin.java.spring.melon.infrastructure.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author zxin
 */
@Slf4j
public class ResultCallerUtils {



    /**
     * 提取实体数据，如果调用响应码失败，直接抛出异常。
     * @param result
     * @param <T>
     * @return
     */
    public static <T> T extractData(Result<T> result){
        return getData(result, "", ResultUtils.SUCCESS_CODE);
    }


    /**
     *
     * @param result
     * @param input
     * @param successCode
     * @param <I> 入参
     * @param <O> 出参
     * @return
     */
    public static <I, O> O getData(Result<O> result, I input, String successCode){
        if(ResultUtils.isSuccess(result, successCode)){
            return result.getData();
        }else{
            log.warn("调用接口出现异常, request:[{}], result:[{}]", JsonUtils.toJson(input), JsonUtils.toJson(result));
            throw new ResultException(result);
        }
    }

    /**
     * feign 方法 调用，
     * 响应失败，抛出{@link ResultException}
     * @param feignFunction
     * @param input
     * @param <I> 入参
     * @param <O> 出参
     * @return
     */
    public static <I, O> O call(Function<I, Result<O>> feignFunction, I input){
        return getData(feignFunction.apply(input), input, ResultUtils.SUCCESS_CODE);
    }

    /**
     *
     * @param feignFunction
     * @param input
     * @param successCode 成功响应码
     * @param <I>
     * @param <O>
     * @return
     */
    public static <I, O> O call(Function<I, Result<O>> feignFunction, I input, String successCode){
        return getData(feignFunction.apply(input), input, successCode);
    }

}
