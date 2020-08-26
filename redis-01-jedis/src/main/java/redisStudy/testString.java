package redisStudy;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.omg.CORBA.TIMEOUT;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * Created by YBM on 2020/8/23 23:19
 */
public class testString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        System.out.println("=================增加数据=================");
        System.out.println(jedis.set("key1","value1"));
        System.out.println(jedis.set("key2","value2"));
        System.out.println(jedis.set("key3","value3"));
        System.out.println("删除键key2:"+jedis.del("key2"));
        System.out.println("获取键key2的值："+jedis.get("key2"));
        System.out.println("修改key1的值："+jedis.set("key1","value1Changed"));
        System.out.println("获取key1的值："+jedis.get("key1"));
        System.out.println("在key3后面加入值："+jedis.append("key3","End"));
        System.out.println("获取key3的值"+jedis.get("key3"));
        System.out.println("增加多个键值对："+jedis.mset("key01","value01","key02","value02","key03","value03","key04","value04"));
        System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03","key04"));
        System.out.println("删除多个键值对："+jedis.del("key01","key02"));
        System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));

        jedis.flushDB();
        System.out.println("=================新增兼职对防止覆盖原先值=================");
        System.out.println(jedis.msetnx("key1","value1","key2","value2","key3","value3","key4","value4"));
        System.out.println(jedis.setnx("key5","value5"));
        System.out.println(jedis.setnx("key6","value6"));
        System.out.println("获取key2"+jedis.get("key2"));
        System.out.println("防覆盖方式添加一个已经存在的属性key2："+jedis.setnx("key2","value-new"));
        System.out.println("获取key2"+jedis.get("key2"));


        System.out.println("=================新增键值对并设置有效时间=================");
        System.out.println(jedis.setex("key3",2,"value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));


        System.out.println("=================获取原值,更新为新值=================");
        System.out.println(jedis.getSet("key2","key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println("获取key2的值的字符串："+jedis.getrange("key2",2,4));
    }
}
