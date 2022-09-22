package com.zxin.java.spring.melon.infrastructure.util.spring;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * @author zxin
 */
public class SpELUtils {

    private static final SpelExpressionParser parser = new SpelExpressionParser();

    private static final ParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    /**
     * 解析表达式
     * 根据方法元数据，方法参数，解析表达式
     * @param expressionString
     * @param method
     * @param args
     * @return
     */
    public static String parseExpression(String expressionString, Method method, Object[] args){
        Expression expression = parser.parseExpression(expressionString);
        String[] params = discoverer.getParameterNames(method);

        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return expression.getValue(context, String.class);
    }

}
