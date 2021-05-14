package com.javasm.test;

import cn.hutool.core.date.DateUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/14-19:23
 * @Since:jdk1.8
 * @Description:TODO
 */
public class WordTest {
    public static void main(String[] args) {
        exportWord();
    }

    public static void exportWord(){
        //导出的文件地址
        File file = new File("C:\\Users\\Administrator\\Desktop\\租房合同.doc");
        try (
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
        ){

            HashMap<String, String> map = new HashMap<String, String>(){{
                put("username","张三");
                put("username1","李四");
                put("userCode","42082211111111111");
                put("price","2000");
                put("time", DateUtil.today());
            }};
            //创建配置
            Configuration config = new Configuration();
            //设置模板路径
            config.setClassForTemplateLoading(WordTest.class,"/");
            //设置模板编码格式
            config.setDefaultEncoding("UTF-8");
            //获取模板
            Template template = config.getTemplate("template.xml");
            //执行模板
            template.process(map,outputStreamWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}