package com.javasm;


import redis.clients.jedis.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        singleRedis();
        multiRedis();
    }

    /**
     * 单一的redis实例
     */
    public static void singleRedis() {
        /*
            URI写法 : schema[协议]://username:password@host:port
            - username:password@ 可以省略
        */
        try {
            URI uri = new URI("redis://a:javasm@localhost:6379/0");
            Jedis jedis = new Jedis(uri);
            String jedis_test_1 = jedis.set("jedis_test_1", "{userName:tom,age:29}");
            System.out.println(jedis_test_1);
            jedis.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个redis实例
     */
    public static void multiRedis() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(5);
        jedisPoolConfig.setMaxIdle(5);

        ArrayList<JedisShardInfo> jedisShardInfos = new ArrayList<>(10);
        try {
            jedisShardInfos.add(new JedisShardInfo(new URI("redis://a:javasm@localhost:6379/0")));
            jedisShardInfos.add(new JedisShardInfo(new URI("redis://a:javasm@localhost:6380/0")));
            ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,jedisShardInfos);
            ShardedJedis jedis = shardedJedisPool.getResource();
            for (int i = 0; i < 10; i++) {
                jedis.set("multi_redis_test_"+i,""+i);
            }
            jedis.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
