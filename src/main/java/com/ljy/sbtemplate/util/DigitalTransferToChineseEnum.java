package com.ljy.sbtemplate.util;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 中文转数字
 */
@Getter
public enum DigitalTransferToChineseEnum {
    ONE("一","1"),
    TWO("二","2"),
    THREE("三","3"),
    FOUR("四","4"),
    FIVE("五","5"),
    SIX("六","6"),
    SEVEN("七","7"),
    EIGHT("八","8"),
    NINE("九","9"),
    TEN("十","10"),
    ELEVEN("十一","11"),
    TWELVE("十二","12"),
    THIRTEEN("十三","13"),
    FOURTEEN("十四","14"),
    FIFTEEN("十五","15"),
    SIXTEEN("十六","16"),
    SEVENTEEN("十七","17"),
    EIGHTTEEN("十八","18"),
    NINETEEN("十九","19"),
    TWENTY("二十","20");

    private String chinese;
    private String number;

    DigitalTransferToChineseEnum(String chinese, String number){
        this.chinese = chinese;
        this.number = number;
    }
    //中文转数字
    public static String getNumber(String chinese){
        if(StringUtils.isNotBlank(chinese)){
            for(DigitalTransferToChineseEnum number: DigitalTransferToChineseEnum.values()){
                if(chinese.equalsIgnoreCase(number.getChinese())){
                    return number.getNumber();
                }
            }
        }
        return null;
    }

    public static String  getChinese(String number){
        if(StringUtils.isNotBlank(number)){
            for(DigitalTransferToChineseEnum chinese: DigitalTransferToChineseEnum.values()){
                if(number.equalsIgnoreCase(chinese.getNumber())){
                    return chinese.getChinese();
                }
            }
        }
        return null;
    }
}
