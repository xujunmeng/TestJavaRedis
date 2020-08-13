package simple.脚本;

import com.google.common.io.CharStreams;
import org.junit.Test;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import simple.BaseTestCase;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * 案例-实现访问频率限制: 实现访问者 $ip 在一定的时间 $time 内只能访问 $limit 次.
 *
 * @author james
 * @date 2018/6/20
 */
public class ScriptMain extends BaseTestCase{

    @Test
    public void test() {
        Collection<Jedis> jedises = jedis.getAllShards();
        for (Jedis jedise : jedises) {
            for (int i = 0; i < 100; i++) {
                boolean b = accessLimit("127.0.0.1", 10, 500, jedise);
                if (b) {
                    System.out.println("在限制的次数内，操作的业务逻辑");
                }
            }
        }
    }

    /**
     *
     * @param ip  访问者ip
     * @param limit  只能访问次数
     * @param time  一定的时间
     * @param jedis
     * @return
     */
    private boolean accessLimit(String ip, int limit, int time, Jedis jedis) {
        boolean result = true;

        String key = "rate.limit:" + ip;
        if (jedis.exists(key)) {
            long afterValue = jedis.incr(key);
            if (afterValue > limit) {
                result = false;
            }
        } else {
            Transaction transaction = jedis.multi();
            transaction.incr(key);
            transaction.expire(key, time);
            transaction.exec();
        }
        return result;
    }

    @Test
    public void test2() throws IOException {
        Collection<Jedis> jedises = jedis.getAllShards();
        for (Jedis jedise : jedises) {
            for (int i = 0; i < 100; i++) {
                boolean b = accessLimit2("127.0.0.2", 10, 500, jedise);
                if (b) {
                    System.out.println("在限制的次数内，操作的业务逻辑");
                }
            }
        }
    }

    private boolean accessLimit2(String ip, int limit, int timeout, Jedis jedis) throws IOException {
        List<String> keys = Collections.singletonList(ip);
        List<String> argv = Arrays.asList(String.valueOf(limit), String.valueOf(timeout));

        return 1 == (Long) jedis.eval(loadScriptString("script.lua"), keys, argv);
    }

    /**
     * 加载Lua代码
     * @param fileName 文件名
     * @return
     * @throws IOException
     */
    private String loadScriptString(String fileName) throws IOException {
        Reader reader = new InputStreamReader(Client.class.getClassLoader().getResourceAsStream(fileName));
        return CharStreams.toString(reader);
    }
}
