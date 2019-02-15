package com.ljy.sbtemplate.service.temp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljy.sbtemplate.dal.dao.sbt.custom.TempMapperCustom;
import com.ljy.sbtemplate.model.po.sbt.mbg.Temp;
import com.ljy.sbtemplate.model.request.temp.TempParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description
 */
@Service
public class TempService {

    @Autowired
    private TempMapperCustom tempMapperCustom;


    public PageInfo<Temp> list(TempParam tempParam){
        PageHelper.startPage(tempParam.getPageNum(), tempParam.getPageSize());
        List<Temp> all = tempMapperCustom.all();

        return new PageInfo<>(all);
    }

    public Temp get(Integer id){
        return tempMapperCustom.selectByPrimaryKey(id);
    }


    public int save(TempParam tempParam){
        Temp temp = new Temp();
        BeanUtils.copyProperties(tempParam,temp);
        return tempMapperCustom.insertSelective(temp);
    }

    public int update(TempParam tempParam){
        Temp temp = new Temp();
        temp.setId(tempParam.getId());
        temp.setName(tempParam.getName());
        return tempMapperCustom.updateByPrimaryKeySelective(temp);
    }

    public int delete(Integer id){
        return tempMapperCustom.deleteByPrimaryKey(id);
    }
}
