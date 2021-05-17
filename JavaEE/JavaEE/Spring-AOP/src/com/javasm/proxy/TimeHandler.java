package com.javasm.proxy;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/4-20:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TimeHandler implements IHandler{
    /**
     * 开始时间
     */
    private Long beforeTime;
    /**
     * 结束时间
     */
    private Long afterTime;
    @Override
    public void doBefore(ProxyMethod proxyMethod) {
        this.beforeTime = System.currentTimeMillis();
    }

    @Override
    public void doAfter(ProxyMethod proxyMethod) {
        this.afterTime = System.currentTimeMillis();
        System.out.println("共耗时 : " + (afterTime - beforeTime) );
    }

    @Override
    public void doError(ProxyMethod proxyMethod) {

    }

    @Override
    public void doReturn(ProxyMethod proxyMethod) {

    }
}