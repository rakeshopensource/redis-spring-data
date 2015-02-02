package rakeshopensource.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import rakeshopensource.redis.model.Cachable;
import rakeshopensource.redis.model.Data;
import rakeshopensource.redis.service.CachingService;

@Service("cacheService")
public class CachingServiceImpl implements CachingService<Cachable>{

	@Autowired
	RedisTemplate<String, Cachable> redisTemplate;
	
	public void put(Cachable obj) {
		redisTemplate.opsForHash().put(obj.getObjectKey(), obj.getKey(), obj);
		
	}

	public Cachable get(Cachable key) {
		return (Data) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}

	public void delete(Cachable key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
		
	}

}