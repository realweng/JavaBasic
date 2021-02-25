package com.java.student.test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-17:10
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SimpleStudentStream extends ObjectOutputStream {
    public SimpleStudentStream(OutputStream out) throws IOException {
        super(out);
    }

    protected SimpleStudentStream() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        return;
    }
}