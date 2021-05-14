package com.javasm.constants;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/12-22:10
 * @Since:jdk1.8
 * @Description:全局常量
 */
public interface Constants {
    /**
     * redis 模拟session的过期时间
     */
    Integer REDIS_SESSION_EXPIRE = 30 * 60;
    /**
     *  注册验证码的有效期
     */
    Integer SMS_CODE_REGISTER_EXPIRE = 10*60;


    /**
     *短信key Id
     */
    String SMS_ACCESSKEY_ID = "LTAI4G53JGV6nSUWA3GEw6JE";
    /**
     *   短信密钥
     */
    String SMS_ACCESSKEY_SECRET = "82TlykLx2d1uFFIpBj9mfa4tmHz3p2";
    /**
     *   短信模板签名
     */
    String SMS_ACCESSKEY_SIGNNAME = "王绍成";
    /**
     *   短信模板代码
     */
    String SMS_ACCESSKEY_TEMPLATECODE = "SMS_109030028";
}
