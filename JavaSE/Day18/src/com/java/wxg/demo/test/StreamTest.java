package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-17:41
 * @Since:jdk1.8
 * @Description: Stream流 list map的转换
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("111");
        list.add("121");
        list.add("111");
        list.add("131");
        list.add("141");
        list.add("151");
        //获取流->打开
        //获取个数
        System.out.println("集合的个数："+list.stream().count());
        //去重复
        Stream<String> distinct = list.stream().distinct();
        System.out.println(distinct);//输出的是流

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println("去重复的结果："+collect);

        List<Person> personList = new ArrayList<>(10);
        personList.add(new Person(11,"111"));
        personList.add(new Person(12,"121"));
        personList.add(new Person(13,"131"));
        personList.add(new Person(14,"141"));
        personList.add(new Person(15,"151"));

        //将List放入Map中
        HashMap<Integer,String> map = new HashMap<>(16);
        for (Person person : personList) {
            map.put(person.getId(),person.getName());
        }
        System.out.println(map);

        //通过流将List放入Map中
        Map<Integer, String> collectMap = personList.parallelStream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(collectMap);

        //Function.identity代表当前对象
        Map<Integer, Person> collectMap2 = personList.parallelStream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(collectMap2);
    }
}