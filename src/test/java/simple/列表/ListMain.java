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
