package rakeshopensource.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import rakeshopensource.redis.model.Cachable;
import rakeshopensource.redis.service.CachingService;

@Service("cacheService")
public class CachingServiceImpl implements CachingService<Cachable>{

	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate<String, Cachable> redisTemplate;
	
	public void put(Cachable cachableObj) {
		redisTemplate.opsForHash().put(cachableObj.getObjectKey(), cachableObj.getKey(), cachableObj);
		
	}

	public Cachable get(Cachable key) {
		return (Cachable) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}

	public void delete(Cachable key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
		
	}
	
	public Cachable find(Cachable key) {
		if(get(key)==null) {
			put(key);
		}
		return get(key);
	}
}