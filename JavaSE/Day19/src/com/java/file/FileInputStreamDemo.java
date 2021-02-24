package com.java.file;

import java.io.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-17:03
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        File file = new File("E:\\1.txt");
        try {
            int result = 0;
            inputStream = new java.io.FileInputStream(file);
//            StringBuffer stringBuffer = new StringBuffer();
//            while ((result = inputStream.read()) != -1) {
//                stringBuffer.append(result);
//            }
//            System.out.println(stringBuffer.toString());

//            byte bytes[] = new byte[(int) file.length()];
//            while ((result = inputStream.read(bytes)) != -1) {
//                System.out.println(new String(bytes,0,result));
//            }

            byte bytes1[] = new byte[1024];
            while ((result = inputStream.read(bytes1,0,bytes1.length))!=-1){
                System.out.println(new String(bytes1,0,result));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if(inputStream!=null){
                inputStream.close();
            }
        }
    }
}