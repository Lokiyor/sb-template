package com.ljy.sbtemplate.dal.dao.sbt.mbg;

import com.ljy.sbtemplate.model.po.sbt.mbg.Temp;
import com.ljy.sbtemplate.model.po.sbt.mbg.TempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int countByExample(TempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int deleteByExample(TempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int insert(Temp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int insertSelective(Temp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    List<Temp> selectByExample(TempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    Temp selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int updateByExampleSelective(@Param("record") Temp record, @Param("example") TempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int updateByExample(@Param("record") Temp record, @Param("example") TempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int updateByPrimaryKeySelective(Temp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp
     *
     * @mbggenerated Thu Feb 14 17:31:25 CST 2019
     */
    int updateByPrimaryKey(Temp record);
}