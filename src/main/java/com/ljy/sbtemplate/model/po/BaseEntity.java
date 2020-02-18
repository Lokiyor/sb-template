package com.ljy.sbtemplate.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Lokiy
 * @date 2020/2/18 0018
 * @description:
 */
@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
}
