package com.d.work.redis;

import redis.clients.jedis.ShardedJedis;

/**
@author junmeng.xu
@date  2016年4月20日下午1:23:56
 */
public interface RedisDataSource {

	abstract ShardedJedis getRedisClient();
	
	void returnResource(ShardedJedis shardedJedis);
	
	void returnResource(ShardedJedis shardedJedis , boolean broken);
	
}
