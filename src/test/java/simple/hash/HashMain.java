package simple.hash;

import org.junit.Test;
import redis.clients.jedis.ShardedJedisPipeline;
import simple.BaseTestCase;

import java.util.Map;

/**
 * @author james
 * @date 2018/6/20
 */
public class HashMain extends BaseTestCase {

    @Test
    public void test() {
        ShardedJedisPipeline pipeline = jedis.pipelined();//流水线一次性提交
        for(int i=0;i<10;i++){
            pipeline.hset("hash","key"+i,String.valueOf(i));
        }
        pipeline.sync();
        Map<String, String> hash = jedis.hgetAll("hash");
        System.out.println(hash);
    }

    @Test
    public void test3() {
        String hget = jedis.hget("hash", "key1");
        System.out.println(hget);
    }

    @Test
    public void test2() {
        Boolean hexists = jedis.hexists("hash", "key0");
        System.out.println(hexists);


    }

}
