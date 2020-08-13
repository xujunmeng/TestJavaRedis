package simple.set;

import org.junit.Test;
import simple.BaseTestCase;

/**
 * @author james
 * @date 2018/6/20
 */
public class SetMain extends BaseTestCase {

    @Test
    public void test() {

        Long sadd = jedis.sadd("set", "a", "b");
        System.out.println(sadd);



    }

    @Test
    public void ssetrr2() {
        String set = jedis.set("key", "value", "a", "a", 60);
        System.out.println(set);
    }

}
