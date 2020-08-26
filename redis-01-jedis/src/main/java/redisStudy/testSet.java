package redisStudy;

import redis.clients.jedis.Jedis;

/**
 * Created by YBM on 2020/8/24 23:33
 */
public class testSet {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        System.out.println("================向集合中添加元素不重复==============");
        System.out.println(jedis.sadd("eleSet","e1","e2", "e3","e0","e8","e7","e5"));
        System.out.println(jedis.sadd("eleSet","e6"));
        System.out.println(jedis.sadd("eleSet","e6"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("删除一个元素e0："+jedis.srem("eleSet","e0"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("随机移除一个集合中的元素："+jedis.spop("eleSet"));
        System.out.println("eleSet的所有元素为："+jedis.smembers("eleSet"));
        System.out.println("e3是否在eleSet中："+jedis.sismember("eleSet","e3"));
        System.out.println("e1是否在eleSet中："+jedis.sismember("eleSet","e1"));
        System.out.println("e5是否在eleSet中："+jedis.sismember("eleSet","e5"));
        System.out.println("========================================");
        System.out.println(jedis.sadd("eleSet1","e1","e2", "e3","e0","e8","e7","e5"));
        System.out.println(jedis.sadd("eleSet2","e1","e2", "e4","e0","e8"));
        System.out.println("将eleSet1中删除e1并存入eleSet3中："+jedis.smove("eleSet1","eleSet3","e1"));//移动到集合元素
        System.out.println("将eleSet1中删除e2并存入eleSet3中："+jedis.smove("eleSet1","eleSet3","e2"));
        System.out.println("eleSet1的所有元素为："+jedis.smembers("eleSet1"));
        System.out.println("eleSet3的所有元素为："+jedis.smembers("eleSet3"));
        System.out.println("====================集合运算===========================");
        System.out.println("eleSet1的所有元素为："+jedis.smembers("eleSet1"));
        System.out.println("eleSet2的所有元素为："+jedis.smembers("eleSet2"));
        System.out.println("eleSet1和eleSet2的交集："+jedis.sinter("eleSet1","eleSet2"));
        System.out.println("eleSet1和eleSet2的并集："+jedis.sunion("eleSet1","eleSet2"));
        System.out.println("eleSet1和eleSet2的查集："+jedis.sunion("eleSet1","eleSet2"));//eleSet1中有，eleSet2中没有的

        System.out.println("求eleSet1，eleSet2交接并保存到eleSet4："+jedis.sinterstore("eleSet4","eleSet1","eleSet2"));
        System.out.println("eleSet4的所有元素为："+jedis.smembers("eleSet4"));

    }
}
