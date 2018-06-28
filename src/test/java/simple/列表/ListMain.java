package simple.列表;

import org.junit.Test;
import simple.BaseTestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author james
 * @date 2018/6/20
 */
public class ListMain extends BaseTestCase {

    @Test
    public void test() {
        //存储数据到列表中
        String key = "site-list";
        jedis.lpush(key, "Runoob");
        jedis.lpush(key, "Google");
        jedis.lpush(key, "Taobao");

        List<String> strings = jedis.lrange(key, 0, 10);
        System.out.println(strings);
    }

    @Test
    public void test5() {
        String key = "site-list";
        List<String> strings = jedis.lrange(key, 0, 10);
        System.out.println(strings);
    }

    /**
     * 返回列表key中指定区间内的元素,区间以偏移量start和stop指定.
     * 下标(index)参数start和stop从0开始;
     * 负数下标代表从后开始(-1表示列表的最后一个元素,-2表示列表的倒数第二个元素,以此类推)
     */
    @Test
    public void test8() {
        String key = "site-list";
        List list = jedis.lrange(key, 0, -1);//stop下标也在取值范围内(闭区间)
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2() {
        //存储数据到列表中
        String key = "list";
        String[] vals =new String[]{"vvv", "bbb", "ccc"};
        jedis.lpush(key, vals);
    }

    @Test
    public void test3() {
        //存储数据到列表中
        String key = "list-array";
        List<String> vals = new ArrayList<>();
        vals.add("vvv");
        vals.add("ccc");
        vals.add("www");
        jedis.lpush(key, vals.toString());
    }

}
