package com.zxin.java.spring.melon.infrastructure.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author zxin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    @NotNull
    @ApiModelProperty("分页，页码")
    private Long current = 1L;

    @NotNull
    @ApiModelProperty("分页，每页数据行")
    private Long size = 10L;

}
