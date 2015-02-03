package rakeshopensource.redis.model;

import java.io.Serializable;

public interface Cachable extends Serializable{
	public String getObjectKey();
	public String getKey();
}
