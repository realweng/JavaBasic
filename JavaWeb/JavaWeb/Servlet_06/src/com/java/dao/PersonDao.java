package com.java.dao;

import com.java.annotation.InjectPerson;
import com.java.entity.Person;
import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/9-17:17
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
public class PersonDao {
    private Person person;

    @InjectPerson(username = "张三",age = 23)
    public void setPerson(Person person) {
        this.person = person;
    }
}