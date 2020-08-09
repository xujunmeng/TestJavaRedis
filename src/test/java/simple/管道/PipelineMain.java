package simple.管道;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import simple.BaseTestCase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author james
 * @date 2018/6/20
 */
public class PipelineMain extends BaseTestCase {

    @Test
    public void test() {
        Collection<Jedis> jedises = jedis.getAllShards();
        for (Jedis jedise : jedises) {
            long start = System.currentTimeMillis();
            notusePipeline(jedise);
            long end = System.currentTimeMillis();
            System.out.println("=====================不使用Pipeline的方式用时:%d毫秒" + (end-start));

            start = System.currentTimeMillis();
            usePipeline(jedise);
            end = System.currentTimeMillis();
            System.out.println("==================使用Pipeline的方式用时:%d毫秒" + (end-start));
        }
    }

    private static void notusePipeline(Jedis jedis) {
        Map<String, String> mp = new HashMap<String, String>();
        try {
            for (int i=0; i<10000; i++) {
                mp.clear();
                mp.put("k"+i, "v"+i);
                jedis.hmset("keys"+i, mp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void usePipeline(Jedis jedis) {
        Map<String, String> mp = new HashMap<String ,String >();
        try {
            Pipeline pl = jedis.pipelined();
            for (int i=0; i<10000; i++) {
                mp.clear();
                mp.put("k"+i, "v"+i);
                pl.hmset("keys"+i, mp);
            }
            pl.sync();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
