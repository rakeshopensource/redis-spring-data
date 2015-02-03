package rakeshopensource.redis.model;

public class Data implements Cachable{

	private static final long serialVersionUID = 9200903542564188618L;
	
	private String hashKey;
	private String module;
	private String value;
	
	public Data() {
		
	}
	
	public Data(String hashKey,  String module){
		this.hashKey = hashKey;
		this.module= module;
	}
	
	public Data(String hashKey,  String module, String value){
		this.hashKey = hashKey;
		this.module= module;
		this.value = value;
	}
	
	

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	public String getKey() {
		return getHashKey();
	}
	
	public String getObjectKey() {
		return getModule();
	}

	 @Override
	 public String toString() {
	        return String.format("[ Module : "  + module + " ] [Key : " + hashKey + " ] [ Value : " + value + " ]");
	 }
	

	
}
