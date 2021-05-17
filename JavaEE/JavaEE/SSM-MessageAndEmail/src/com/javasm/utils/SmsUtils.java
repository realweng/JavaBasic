package com.javasm.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.javasm.constants.Constants;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/14-21:39
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SmsUtils {
//    public static void main(String[] args) {
//        sendCode("18326529881");
//    }

    /**
     * 发送验证码
     * @param phoneNum
     * @return
     */
    public static String sendCode(String phoneNum){
        String random = RandomStringUtils.random(6,false,true);
        sendForAli(phoneNum,random);
        return random;
    }

    /**
     * 阿里云短信发送
     * @param phoneNum
     * @param code
     */
    private static void sendForAli(String phoneNum,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", Constants.SMS_ACCESSKEY_ID, Constants.SMS_ACCESSKEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", Constants.SMS_ACCESSKEY_SIGNNAME);
        request.putQueryParameter("TemplateCode", Constants.SMS_ACCESSKEY_TEMPLATECODE);
        Map<String,Object> param = new HashMap<>();
        param.put("code",code);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(param));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
