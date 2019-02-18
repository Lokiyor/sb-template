package com.ljy.sbtemplate.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class StringUtilities {

    public static final String SEGMENTATION = ",";

    /**
     * 将String 转换成 List<Long>
     *
     * @param str
     * @return
     */
    public static List<Long> splitStrToListLong(String str) {
        List<Long> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(str)) {
            String[] split = StringUtils.split(str, SEGMENTATION);
            for (String string : split) {
                list.add(NumberUtils.toLong(string, -1l));
            }
        }
        return list;
    }

    /**
     * 将String 转换成 List<Integer>
     *
     * @param str
     * @return
     */
    public static List<Integer> splitStrToListInt(String str) {
        List<Integer> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(str)) {
            String[] split = StringUtils.split(str, SEGMENTATION);
            for (String string : split) {
                list.add(NumberUtils.toInt(string, -1));
            }
        }
        return list;
    }

    /**
     * 将String 转换成 List<String>
     *
     * @param str
     * @return
     */
    public static List<String> splitStrToListString(String str) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(str)) {
            String[] split = StringUtils.split(str, SEGMENTATION);
            for (String string : split) {
                list.add(string);
            }
        }
        return list;
    }

    /**
     * 规则替换
     */
    public static String ruleReplace(String StrParam,HashMap<String,String> map){
        //1：编号规则解析:{startTime}-{endTime}；<br>外出原因：{remark}

        String codeParam = StrParam.toLowerCase();
        for (String key : map.keySet()) {
            if(codeParam.contains("{"+key.toLowerCase()+"}")){
                codeParam=  codeParam.replace("{"+key.toLowerCase()+"}",map.get(key));
            }
        }
        return  codeParam;
    }

}
