package com.yxf.gateway.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户手机号注册校验
 *
 * @author Your Name
 */
public class Test2 {

    public static List<String> phones =new ArrayList<>();

    //判断手机号是否符合 0 正确 -1 非法 1 中国大陆非法
    public static String isMobilePhone(String phone) {
        String result = "0";

        phone = phone.replace(" ", "");

        String regexNum = "\\d+";
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            result = "-1";
        } else {
            Pattern p = Pattern.compile(regexNum);
            Matcher m = p.matcher(phone);
            Boolean flagNum = m.matches();
            if (flagNum == false) {
                return "-1";
            }
            Pattern pp = Pattern.compile(regex);
            Matcher mm = pp.matcher(phone);
            Boolean flag = mm.matches();
            if (flag == false) {
                result = "1";
            } else {
                result = "0";
            }

        }

        return result;
    }

    //判断手机号是否注册
    public static Boolean isRegistered(String phone) {
        Boolean result = true;

        phone = phone.replace(" ", "");

        for (String phoneNum : phones) {
            if (phoneNum.equals(phone)) {
                return false;
            }
        }

        return result;
    }

    public static String validateMsg(String phone) {
        String status = isMobilePhone(phone);
        if (status.equals("-1")) {
            return resultDto.ERROR.getMsg();
        } else if (status.equals("1")) {
            return resultDto.ERROR_UNCHINA.getMsg();
        }
        Boolean isRegistered = isRegistered(phone);
        if (isRegistered == false) {
            return resultDto.ERROR_ISREGISTER.getMsg();
        }
        phones.add(phone);
        return resultDto.SUCCESS.getMsg();

    }

    public static void main(String[] args) {
        // TODO 通过此手机号注册成功
        String phoneNum1 = "138 1234 1234";

        // TODO 通过本手机号无法注册，提示为非法手机号
        String phoneNum2 = "13812345abc";

        // TODO 通过此手机号注册成功
        String phoneNum3 = "13812345678";

        // TODO 提示此手机号已经被其他用户注册
        String phoneNum4 = "138 1234 5678";

        // TODO 此手机号码为中国大陆非法手机号码
        String phoneNum5 = "98765432101";

        System.out.println(validateMsg(phoneNum1));
        System.out.println(validateMsg(phoneNum2));
        System.out.println(validateMsg(phoneNum3));
        System.out.println(validateMsg(phoneNum4));
        System.out.println(validateMsg(phoneNum5));


    }



    enum resultDto {
        SUCCESS("通过此手机号注册成功"),
        ERROR("通过本手机号无法注册，提示为非法手机号"),
        ERROR_ISREGISTER("提示此手机号已经被其他用户注册"),
        ERROR_UNCHINA("此手机号码为中国大陆非法手机号码");

        private String msg;

        resultDto(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


    }


}

