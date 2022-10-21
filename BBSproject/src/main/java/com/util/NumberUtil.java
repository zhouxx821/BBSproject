package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class NumberUtil {
     public String getNewToken(String timeStr,int userId){
        //参数是一个时间戳字符串和用户ID
        String src = timeStr + userId + NumberUtil.genRandomNum(4);
        return NumberUtil.genToken(src);
    }
    public static int genRandomNum(int length){
        int num = 1;
        double random = Math.random();//随机生成一个0～1之间的数，不包含1
        if(random < 0.1){
            random = random + 0.1;
        }
        for(int i = 0; i < length; i++){
            num = num * 10;
        }
        return (int)((random * num));
    }
    public static String genToken(String src){
        if(null == src || "".equals(src)){
            return null;
        }
        try{
            //MessageDigest是Java自带的加密类，XX.getInstance("MD5")意为加密MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的byte来更新md
            md.update(src.getBytes());
            //md.digest() 生成摘要,
            //new BigInteger(int sinnum,byte[] magnitude),构造方法，
            //-1表示负数，0表示0，1表示正数
            String result = new BigInteger(1,md.digest()).toString(16);
            if(result.length() == 31){
                result = result + "-";
            }
            System.out.println(result);
            return result;
        }catch(Exception e){
            return null;
        }
    }
}
