--
-- Created by IntelliJ IDEA.
-- User: james
-- Date: 2018/6/20
-- Time: 16:48
-- To change this template use File | Settings | File Templates.
--

local key = "rate.limit:" .. KEYS[1]
local limit = tonumber(ARGV[1])
local expire_time = tonumber(ARGV[2])

local is_exists = redis.call("EXISTS", key)

if is_exists == 1 then
    if redis.call("INCR", key) > limit then
        return 0
    else
        return 1
    end
else
    redis.call("SET", key, 1)
    redis.call("EXPIRE", key, expire_time)
    return 1
end