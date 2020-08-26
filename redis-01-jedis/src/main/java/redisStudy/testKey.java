package redisStudy;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by YBM on 2020/8/23 23:12
 */
public class testKey {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','root'>的键值对："+jedis.set("username","root"));
        System.out.println("新增<'password','password'>的键值对："+jedis.set("password","password"));
        System.out.println("系统值所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password："+jedis.del("password"));
        System.out.println("判断password是否存在："+jedis.exists("password"));
        System.out.println("查看username所存储的值的类型："+jedis.type("user"));
        System.out.println("随机返回key空间的一个："+jedis.randomKey());
        System.out.println("重命名key:"+jedis.rename("username","name"));
        System.out.println("取出改后的name:"+jedis.get("name"));
        System.out.println("按索引查询："+jedis.select(0));
        System.out.println("删除当前数据库中所有的key:"+jedis.flushDB());
        System.out.println("返回当前数据库中key的数量："+jedis.dbSize());
        System.out.println("删除所有数据库中的所有key:"+jedis.flushAll());
    }
}
