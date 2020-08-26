package redisStudy;

import redis.clients.jedis.Jedis;

/**
 * Created by YBM on 2020/8/23 23:39
 */
public class testList {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        System.out.println("============添加一个list============= ");
        System.out.println(jedis.lpush("ArrayList","Vector","Stack","HashMap","linkList"));
        System.out.println(jedis.lpush("collections","HashSet","TreeSet","TreeMap"));
        System.out.println("collection的内容："+jedis.lrange("collections",0,-1));
        System.out.println("collection区间0-3的元素："+ jedis.lrange("collection",0,3));
        System.out.println("===================================");
        //删除列表指定的值，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        System.out.println("删除指定元素个数："+jedis.lrem("collections",2,"HashMap"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("删除collections表0-3区间之外的元素(截取0-3区间内)："+jedis.ltrim("collections",0,3));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("collections列表出栈（左端）："+jedis.lpop("collections"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("collections列表出栈（右端）："+jedis.rpop("collections"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("修改collections指定下标（下标为1）的内容："+jedis.lset("collections",1,"newList"));
        System.out.println("collections的内容："+jedis.lrange("collections",0,-1));
        System.out.println("=========================");
        System.out.println("collections的长度："+jedis.llen("collections"));
        System.out.println("获取collections下标为2的元素："+jedis.lindex("collections",2));
        System.out.println("=========================");
        System.out.println("新建一个sortedList数字的list:"+jedis.lpush("sortedList","3","5","2","7","4"));
        System.out.println("sortedList排序前："+jedis.lrange("sortedList",0,-1));
        System.out.println("对sortedList进行排序："+jedis.sort("sortedList"));
        System.out.println("sortedList排序后："+jedis.lrange("sortedList",0,-1));
    }
}
