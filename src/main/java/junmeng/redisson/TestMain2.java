package junmeng.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author james
 * @date 2020/8/17
 */
public class TestMain2 {

    public static void main(String[] args) throws InterruptedException {

        Config config = new Config();
        config.useSingleServer()
                .setAddress("r-bp134a6c7c2f9334.redis.rds.aliyuncs.com:6379")
                .setPassword("L00easy1db2uat3redis")
                .setDatabase(70);
        RedissonClient redissonClient = Redisson.create(config);

        boolean result = redissonClient.getLock("bbb").tryLock(0, -1, TimeUnit.SECONDS);

        System.out.println(result);

        Thread.sleep(1000000);

        redissonClient.getLock("bbb").unlock();

    }

}
