package utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;


public class SimHash {

    /**
     * 传入String，计算出它的hash值，并以字符串形式输出
     * @param str 传入的String类型字符串
     * @return 返回str的hash值
     */

    public static String getHash(String str){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5"); //使用MD5取出哈希值
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    public static String getSimHash(String str){
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//引入了HanLP工具，取出所有关键词
        try{
            if(str.length() < 200)
                throw new ShortStringException("文本过短,请检查是否符合查重规则");// 文本长度过短时无法通过HanLp取得关键字
        }catch (ShortStringException e){
            e.printStackTrace();
            //return null;
        }


        int words_size = keywordList.size();
        int i=0;
        int[] v = new int[128];
        for(String keyword : keywordList){
            // 获取hash值
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));
            if (keywordHash.length() < 128) {
                int miss_number = 128 - keywordHash.length();            // 对hash值低位补齐0
                keywordHash.append("0".repeat(Math.max(0, miss_number)));
            }
            // 加权 与 合并
            for (int j = 0; j < v.length; j++) {
                // 让keywordHash的每一位都与'1'进行比较，判断为1还是0
                if (keywordHash.charAt(j) == '0') {
                    v[j] -= (10 - (i / (words_size / 10) ) );
                } else {
                    v[j] += (10 - (i / (words_size / 10) ) );
                }
            }
            i++;
        }

        // 降维
        StringBuilder simHash = new StringBuilder();
        for (int k : v) {
            // 从高位遍历到低位
            if (k <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
        }
        return simHash.toString();
    }


}
