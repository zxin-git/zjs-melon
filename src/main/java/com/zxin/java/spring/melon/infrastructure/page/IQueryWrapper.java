package com.zxin.java.spring.melon.infrastructure.page;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 *
 * @param <E>  Entity 实体类型
 * @param <Q>  Query 查询类型
 */
public interface IQueryWrapper<E, Q> {

    Wrapper<E> toWrapper(Q q);

}