package com.java.wxg.stream.test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-15:21
 * @Since:jdk1.8
 * @Description:TODO
 */
public class SimpleObjectOutputStream extends ObjectOutputStream {
    public SimpleObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected SimpleObjectOutputStream() throws IOException, SecurityException {
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        return;
    }
}