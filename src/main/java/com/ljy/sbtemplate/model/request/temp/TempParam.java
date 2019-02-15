package com.ljy.sbtemplate.model.request.temp;

import com.ljy.sbtemplate.model.request.BaseCommonParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description
 */
@Data
public class TempParam extends BaseCommonParam {

    @ApiModelProperty("姓名")
    private String name;
}
