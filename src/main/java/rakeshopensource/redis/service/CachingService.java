package rakeshopensource.redis.service;

import rakeshopensource.redis.model.Cachable;

public interface  CachingService <V extends Cachable> {
	
	public void put(V obj);

	public V get(V key);
	
	public void delete(V key);
}


