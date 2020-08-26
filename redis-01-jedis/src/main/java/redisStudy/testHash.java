package redisStudy;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YBM on 2020/8/24 23:51
 */
public class testHash {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        System.out.println("添加名为hash的hash："+jedis.hmset("hash",map));
        System.out.println("向名为hash的hash中添加key为key5,value为value5："+jedis.hset("hash","key5","value5"));
        System.out.println("散列hash的所有的键值对为："+jedis.hgetAll("hash"));//return map<String>
        System.out.println("散列hash的所有的键为："+jedis.hkeys("hash"));//return set<String>
        System.out.println("散列hash的所有的值为："+jedis.hvals("hash"));//return list<String>
        System.out.println("将key6保存的值加上一个整数没如果key6不存在则添加key6："+jedis.hincrBy("hash","key6",6));
        System.out.println("散列hash的所有的键值对为："+jedis.hgetAll("hash"));//return map<String>
        System.out.println("删除一个或多个键值对："+jedis.hdel("hash","key2"));
        System.out.println("散列hash的所有的键值对为："+jedis.hgetAll("hash"));//return map<String>
        System.out.println("判断hash中是否存在key2:"+jedis.hexists("hash","key2"));
        System.out.println("获取hash中key3的值："+jedis.hget("hash","key3"));
        System.out.println("获取hash中多个值："+jedis.hmget("hash","key2","key3"));

    }
}
