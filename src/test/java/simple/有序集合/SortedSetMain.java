package simple.有序集合;

import org.junit.Test;
import simple.BaseTestCase;

/**
 * @author james
 * @date 2018/6/20
 */
public class SortedSetMain extends BaseTestCase {

    @Test
    public void test() {
        // 向有序集合中加入元素, 成功返回1, 失败返回0
        Long zadd = jedis.zadd("fruit", 5.0, "apple");
        jedis.zadd("fruit", 2.0, "banana");
        jedis.zadd("fruit", 4.0, "orange");
        jedis.zadd("fruit", 8.0, "grape");
        jedis.zadd("fruit", 10.0, "lemon");
        jedis.zadd("fruit", 7.0, "cherry");
        System.out.println(zadd);
    }

    @Test
    public void test2() {
        // 统计某个权重范围内元素个数
        System.out.println("zcount fruit [1.0,5.0]=" + jedis.zcount("fruit", 1.0, 5.0));

        // 查看排名
        System.out.println("zrank fruit grape=" + jedis.zrank("fruit", "grape"));
        System.out.println("zrevrank fruit grape=" + jedis.zrevrank("fruit", "grape"));
    }

}
