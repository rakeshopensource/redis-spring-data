package rakeshopensource.redis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import rakeshopensource.redis.model.Data;
import rakeshopensource.redis.service.CachingService;



public class RedisTemplateTest {

    public static void main(String[] args){
    		
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-conf.xml");
 
    	CachingService<Data> cacheService = (CachingService<Data>)context.getBean("cacheService");
    	
    	Data data = new Data("SalesOrderStatus:0" , "Active");
    	
    	cacheService.put(data);
    	
    	Data data1  = cacheService.get(data);
    	
    	System.out.println(data1.getKey());
    	System.out.println(data1.getValue());
    	
    }
}
