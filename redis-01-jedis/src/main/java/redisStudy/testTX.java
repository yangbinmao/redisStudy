package redisStudy;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Created by YBM on 2020/8/25 0:11
 */
public class testTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","admin");

        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        jedis.watch(result);//开始乐观锁（监视）


        try {

        multi.set("user1",result);
        multi.set("user2",result);
        int i=1/0;  //使代码执行异常
        multi.exec(); //执行事务
    }catch (Exception e){
        multi.discard(); //放弃事务
        e.printStackTrace();
    }finally {
        System.out.println(jedis.mget("user1","user2"));
        jedis.close();  //关闭redis
    }



    }
}
