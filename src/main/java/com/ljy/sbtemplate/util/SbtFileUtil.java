package com.ljy.sbtemplate.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Lokiy
 * @date 2018/6/6
 * @description 文件操作帮助类
 */

public class SbtFileUtil {

    private static final Logger log = LogManager.getLogger();

    /**
     * 判断文件目录是否存在
     * @param file 文件目录
     * @return true:存在或已创建 false:创建失败
     */
    public static boolean mkDir(File file) {
        return !(!file.exists() && !file.isDirectory()) || file.mkdirs();
    }


    /**
     * 根据传入的字节数组复制到相应的文件目录中
     * @param source    字节数组源
     * @param target    目标文件地址
     * @return  true:复制成功 false:复制失败
     */
    public static boolean copyFile(byte[] source, File target){

        try {
            FileCopyUtils.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("SbtFileUtil.copyFile---------------------->复制文件发生错误:"+e.getMessage(), e);
            return false;
        }
        return true;
    }

    public static boolean copyFile(MultipartFile file, File target){
        try {
            return copyFile(file.getBytes(), target);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("SbtFileUtil.copyFile---------------------->复制文件发生错误:"+e.getMessage(), e);
            return false;
        }

    }
}
