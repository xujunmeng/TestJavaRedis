package simple;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
@author junmeng.xu
@date  2016年4月28日上午11:03:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:data-source.xml")
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class BaseTestCase {

    @Autowired
    public ShardedJedisPool shardedJedisPool;

    public ShardedJedis jedis;

    @Before
    public void Before(){
        jedis = shardedJedisPool.getResource();
    }

}
