package rakeshopensource.redis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import rakeshopensource.redis.model.Data;
import rakeshopensource.redis.service.CachingService;



public class RedisTemplateTest {

    public static void main(String[] args){
    		
    	@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-conf.xml");
 
    	@SuppressWarnings("unchecked")
		CachingService<Data> cacheService = (CachingService<Data>)context.getBean("cacheService");
    	
    	Data activeStatus = new Data("sales","status:0" , "active");
    	Data finalStatus = new Data("sales","status:1" , "final");
    	
    	cacheService.put(activeStatus);
    	cacheService.put(finalStatus);
  
    	Data activeStatusKey = new Data("sales","status:0");
    	Data finalStatusKey = new Data("sales","status:1");
    	
    	activeStatus  = cacheService.get(activeStatusKey);
    	finalStatus  = cacheService.get(finalStatusKey);
    	
    	System.out.println(activeStatus.toString());
    	System.out.println(finalStatus.toString());
    	
    	
    	// Store if key doesn't present.
    	Data financeInvoiceGenerated= new Data("finance", "status:0", "invoice generated");
    	financeInvoiceGenerated  = cacheService.find(financeInvoiceGenerated);
    	System.out.println(financeInvoiceGenerated.toString());
    	
    	
    }
}
