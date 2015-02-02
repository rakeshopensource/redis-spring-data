package rakeshopensource.redis.model;

public class Data implements Cachable{

	private static final long serialVersionUID = 9200903542564188618L;
	
	public Data() {
		
	}
	
	public Data(String id, String value){
		this.id = id;
		this.value = value;
	}
	
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String value;
	
	public static final String OBJECT_KEY = "DATA";
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return getId();
	}
	
	public String getObjectKey() {
		return OBJECT_KEY;
	}
}
