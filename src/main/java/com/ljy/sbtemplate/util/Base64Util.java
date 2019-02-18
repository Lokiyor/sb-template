package com.ljy.sbtemplate.util;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author Lokiy
 * @date 2018/7/26
 * @description base64处理
 */
public class Base64Util {

    private static final Logger log = LogManager.getLogger();

    /**
     * 返回base64头像地址
     * @param avatar 数据库存的二进制数组头像
     * @return
     */
    public static String getBase64Avatar(byte[] avatar){
        String suffix = null;
        try {
            MagicMatch magicMatch = Magic.getMagicMatch(avatar);
            suffix = magicMatch.getMimeType();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Base64Util.getBase64Avatar发生错误:"+e.getMessage(),e);
            suffix = "image/jpeg";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("data:")
                .append(suffix)
                .append(";base64,")
                .append(new BASE64Encoder().encode(avatar));
        return sb.toString();
    }

    /**
     * base64转二进制数组存库
     * @param base64Avatar
     * @return
     */
    public static byte[] getByteArrAvatar(String base64Avatar){
        try {
            return new BASE64Decoder().decodeBuffer(base64Avatar.trim());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Base64Util.getByteArrAvatar发生错误:"+e.getMessage(),e);
            return null;
        }

    }


}
