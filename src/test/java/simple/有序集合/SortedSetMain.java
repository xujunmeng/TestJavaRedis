package simple.有序集合;

import org.junit.Test;
import simple.BaseTestCase;

import java.util.Set;

/**
 * Redis ZRANGE命令返回存储在关键的排序元素集合在指定的范围。
 * 该元素被认为是从最低到最高的分值进行排序。
 * 字典顺序用于以相等的分数的元素。
 * 两个开始和停止是从零开始的索引，其中0是第一个元素，1是下一个元素等等。
 * 它们也可以是表示偏移量从有序集的尾部，以-1作为排序的集合的最后一个元素，-2倒数第二元素等负数。
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
    public void test3() {
        Set<String> fruit = jedis.zrange("fruit", 0, -1);
        System.out.println(fruit);
    }

    @Test
    public void test4() {
        Set<String> fruit = jedis.zrange("fruit", 0, 0);
        System.out.println(fruit);
    }

    @Test
    public void test2() {
        // 统计某个权重范围内元素个数
        System.out.println("zcount fruit [1.0,5.0]=" + jedis.zcount("fruit", 1.0, 5.0));

        // 查看排名
        System.out.println("zrank fruit grape=" + jedis.zrank("fruit", "grape"));
        System.out.println("zrevrank fruit grape=" + jedis.zrevrank("fruit", "grape"));
    }

    @Test
    public void test6() {
        Set<String> zrange = jedis.zrange("ITEM_PRICE_(2074)", 0, 0);
        System.out.println(zrange);
    }

}
