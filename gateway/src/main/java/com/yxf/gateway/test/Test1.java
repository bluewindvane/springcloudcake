package com.yxf.gateway.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出最长对称字符串
 *
 * @author Your Name
 */
public class Test1 {
    private static String findLCS(String input) {
        StringBuffer stringBuffer = new StringBuffer();

        //长度最长结果
        List<String> result = new ArrayList<>();

        //横向纵向对称list所有结果
        List<String> list = new ArrayList<>();


        // 将字符串反转
        String reverse = new StringBuilder(input).reverse().toString();

        // 字符串长度
        int len = input.length();

        // 矩阵 -> 二维数组
        int[][] temp = new int[len][len];

        // 横向字符
        char[] hor = input.toCharArray();

        // 纵向字符
        char[] ver = reverse.toCharArray();

        // 给矩阵(二维数组赋值)
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = (hor[j] == ver[i]) ? 1 : 0;
            }
        }

        // 找到第一行所有横向
        List<Integer> horIndex = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (temp[0][i] == 1) {
                horIndex.add(i);
            }
        }

        // 找到第一列所有纵向
        List<Integer> verIndex = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (temp[i][0] == 1) {
                verIndex.add(i);
            }
        }

        //横向遍历一部分
        int indexHor = 0;
        if (horIndex.size() > 0) {
            for (Integer horIndexTemp : horIndex) {
                StringBuffer horresult = new StringBuffer();
                for (int i = horIndexTemp; i < len; i++) {
                    if (temp[indexHor++][i] == 1) {
                        horresult.append(hor[i]);
                    }
                }
                list.add(horresult.toString());
                horresult = null;
            }

        }

        //纵向遍历一部分
        int indexVer = 0;
        if (verIndex.size() > 0) {
            for (Integer verIndexTemp : verIndex) {
                StringBuffer verresult = new StringBuffer();
                Integer intSize = len - verIndexTemp;
                for (int i = 0; i < intSize; i++) {
                    if (temp[verIndexTemp++][i] == 1) {
                        verresult.append(hor[i]);
                    }
                }
                list.add(verresult.toString());
                verresult = null;
            }
        }

        //此时list中有全部的对称字符串，最后处理并输出结果
        String tempMax = "";
        //找出最长值
        for (String templist : list) {
            if (templist.length() > tempMax.length()) {
                tempMax = templist;
            }
        }
        //取出长度等于最长值长度的值
        for (String templist : list) {
            if (templist.length() == tempMax.length()) {
                result.add(templist);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i != 0) {
                stringBuffer.append("/");
            }
            stringBuffer.append(result.get(i));
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        // TODO 输出最长对称字符串：aba
        String input2 = "abcda";

        // TODO 输出2个最长对称字符串：pop/upu
        String input3 = "pop-upu";

        String input4 = "abcbaea";

        System.out.println(input1 + " -> " + findLCS(input1)); // 结果: google -> goog
        System.out.println(input2 + " -> " + findLCS(input2)); // 结果: abcda -> aca
        System.out.println(input3 + " -> " + findLCS(input3)); // 结果: opo-upu -> opo/upu
    }
}
