package com.ljy.sbtemplate.model.po;

import com.ljy.sbtemplate.model.po.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lokiy
 * @since 2020-02-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Abc对象", description="")
public class Abc extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;


}
