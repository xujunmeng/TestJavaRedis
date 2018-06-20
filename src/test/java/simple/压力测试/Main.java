package simple.压力测试;

import org.junit.Test;
import org.springframework.core.task.support.ExecutorServiceAdapter;
import simple.BaseTestCase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author james
 * @date 2018/6/20
 */
public class Main extends BaseTestCase{

    @Test
    public void test() {
        long beginDate = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            jedis.set("xxx" + i, "valvalvalval=====" + i);
        }
        long endDate = System.currentTimeMillis();
        System.out.println(endDate - beginDate);
    }

}
