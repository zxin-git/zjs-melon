package com.zxin.java.spring.melon.infrastructure.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author zxin
 */
@Data
public class PageResponse<T> {

    /**
     * 查询数据列表
     */
    @ApiModelProperty("查询数据列表")
    private List<T> records = Collections.emptyList();

    /**
     * 每页显示条数，默认 10
     */
    @ApiModelProperty("每页显示条数")
    private long size;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private long current;

    /**
     * 总数
     */
    @ApiModelProperty("总条数")
    private long total;

    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private long pages;

}
