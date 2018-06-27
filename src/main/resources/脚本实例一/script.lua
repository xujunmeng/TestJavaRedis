--
-- Created by IntelliJ IDEA.
-- User: james
-- Date: 2018/6/20
-- Time: 16:48
-- To change this template use File | Settings | File Templates.
--

local value = ARGV[1]

local documentNo = ARGV[2]

-- recyclerId 对 quotation_item 的最近一次出价 zset
local KEY_PATTERN_TEST_1 = 'ITEM_PRICE_(%d)'

local model = cjson.decode(value)
local itemId = model['quotationItemId']

local itemRriceKey = string.format(KEY_PATTERN_TEST_1, itemId)

local lowestPrice = redis.call("ZRANGE", itemRriceKey, 0, 0, "WITHSCORES")[2]