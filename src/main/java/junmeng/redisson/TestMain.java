package junmeng.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.IOException;

/**
 * @author james
 * @date 2020/8/13
 */
public class TestMain {

    public static void main(String[] args) throws IOException {


        doSomething();




    }

    public static void doSomething() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("r-bp134a6c7c2f9334.redis.rds.aliyuncs.com:6379")
                .setPassword("L00easy1db2uat3redis")
                .setDatabase(70);
        RedissonClient redissonClient = Redisson.create(config);

        RedissonLockHelper redissonLockHelper = new RedissonLockHelper("test-service", redissonClient);

        LockHolder lockHolder = redissonLockHelper.getLock("aaa");
        try {
            if (lockHolder == null) {
                return;
            }

            Thread.sleep(1000);
            System.out.println("哈哈哈");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redissonLockHelper.release(lockHolder);
        }
    }

}
