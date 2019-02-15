package com.ljy.sbtemplate.dal.dao.sbt.custom;


import com.ljy.sbtemplate.dal.dao.sbt.mbg.TempMapper;
import com.ljy.sbtemplate.model.po.sbt.mbg.Temp;

import java.util.List;

public interface TempMapperCustom extends TempMapper {

    /**
     * 查询所有
     * @return
     */
    List<Temp> all();
}