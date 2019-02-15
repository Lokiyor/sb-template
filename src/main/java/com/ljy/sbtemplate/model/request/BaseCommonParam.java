package com.ljy.sbtemplate.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description
 */
@Data
public class BaseCommonParam {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty(value = "当前页码")
    @Min(value = 1,message = "当前页码不合法")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页显示数量")
    @Min(value = 1,message = "每页展示数量不合法")
    private Integer pageSize = 10;
}
