package rakeshopensource.redis.model;

import java.io.Serializable;

public interface Cachable extends Serializable{
	
	public String getKey();
	public String getObjectKey();
	
}
