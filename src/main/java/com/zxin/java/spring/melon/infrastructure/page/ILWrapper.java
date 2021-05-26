package com.zxin.java.spring.melon.infrastructure.page;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxin.java.spring.melon.domain.entity.UkeUserInfo;

/**
 * @author zxin
 */
public class ILWrapper implements IQueryWrapper<String, String> {
    @Override
    public Wrapper<String> toWrapper(String s) {
        LambdaQueryWrapper<UkeUserInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.orderByAsc(UkeUserInfo::getUserId);
        return null;
    }
}
