package com.java.project.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:17
 * @Since:jdk1.8
 * @Description:修车厂类
 */

/**
 * Java描述修车厂，修车厂具备，名字、地址、电话三个属性，具备修车的功能行为，
 */
public class CarFactory {
   private String name;
   private String address;
   private String phone;

    /**
     * 修车方法
     */
   public void fixCar(Car car){
       System.out.println("修车厂在修车");
       car.setWheelNums(4);
       System.out.println("车修好了！");
   }

    public CarFactory(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public CarFactory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}