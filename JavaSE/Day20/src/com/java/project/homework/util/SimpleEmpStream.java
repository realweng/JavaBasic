package com.java.project.homework.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-19:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SimpleEmpStream extends ObjectOutputStream {
    public SimpleEmpStream(OutputStream out) throws IOException {
        super(out);
    }

    protected SimpleEmpStream() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader();
        return;
    }
}