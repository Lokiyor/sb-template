package com.ljy.sbtemplate.util;

import com.github.pagehelper.PageInfo;

/**
 * @author Lokiy
 * @date 2018/8/9
 * @description
 * 用于处理分页的一些问题
 */
public class PageInfoUtil {

    /**
     * 完善pageInfo的total和pages
     * @param pageInfo
     * @param pageNum
     * @param pageSize
     * @param total
     * @param pages
     * @return
     */
    public static PageInfo<?> consummate(PageInfo<?> pageInfo,
                                         Integer pageNum, Integer pageSize,
                                         Long total, Integer pages){
        if(pageInfo == null){
            throw new NullPointerException("PageInfoUtil.consummate中PageInfo为空");
        }
        if(pageNum != null){
            pageInfo.setPageNum(pageNum);
        }
        if(pageSize != null){
            pageInfo.setPageSize(pageSize);
        }
        if(total != null){
            pageInfo.setTotal(total);
        }
        if(pages != null){
            pageInfo.setPages(pages);
        }
        return pageInfo;
    }
}
