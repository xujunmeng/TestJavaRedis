使用RedisTemplateAPI

方法	子API接口	描述
opsForValue()	ValueOperations	描述具有简单值的条目
opsForList()	ListOperations	操作具有list值的条目
opsForSet()	SetOperations	操作具有set值的条目
opsForZSet()	ZSetOperations	操作具有ZSet值（排序的set）的条目
opsForHash()	HashOperations	操作具有hash值的条目
boundValueOps(K)	BoundValueOperations	以绑定指定key的方式，操作具有简单值的条目
boundListOps(K)	BoundListOperations	以绑定指定key的方式，操作具有list的条目
boundSetOps(K)	BoundSetOperations	以绑定指定key的方式，操作具有set的条目
boundZSet(K)	BoundZSetOperations	以绑定指定key的方式，操作具有ZSet（排序的set）的条目
boundHashOps(K)	BoundHashOperations	以绑定指定key的方式，操作具有hash值的条目