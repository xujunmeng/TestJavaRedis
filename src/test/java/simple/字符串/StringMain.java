package simple.字符串;

import org.junit.Test;
import simple.BaseTestCase;

/**
 * @author james
 * @date 2018/6/20
 */
public class StringMain extends BaseTestCase {

    @Test
    public void testString() {
        jedis.set("xxx", "valvalvalval");
        String xxx = jedis.get("xxx");
        System.out.println(xxx);
    }

    @Test
    public void testString2() {
        Long append = jedis.append("xxx", "xcxcv");
        System.out.println(append);
    }

}
