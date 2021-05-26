package com.zxin.java.spring.melon.infrastructure.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zxin
 */
public final class PageUtils {

    /**
     * page 转换成 DTO
     */
    public static <I, O> PageResponse<O> toPageResponse(IPage<I> page, Function<I, O> mapper){
        PageResponse<O> oPage = toPageResponse(page);
        if(page != null && CollectionUtils.isNotEmpty(page.getRecords())){
            List<O> list = page.getRecords().stream().map(mapper).collect(Collectors.toList());
            oPage.setRecords(list);
        }
        return oPage;
    }

    public static <T> IPage<T> fromPageRequest(PageRequest pageRequest){
        Page<T> page = new Page<>(pageRequest.getCurrent(), pageRequest.getSize());
        return page;
    }


    public static <I, O> PageResponse<O> toPageResponse(IPage<I> page){
        PageResponse<O> pageResponse = new PageResponse<>();
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setSize(page.getSize());
        pageResponse.setTotal(page.getTotal());
        pageResponse.setPages(page.getPages());
        return pageResponse;
    }

    public static <I, O> IPage<O> convert(IPage<I> page, Function<I, O> mapper){
        Assert.notNull(page, "page is null");
        return page.convert(mapper);
    }

}
