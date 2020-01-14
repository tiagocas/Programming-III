package guiao13;

public class KeyValue {
	private String key;
	private int value;
	
	public KeyValue(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getKey() {
		return this.key;
	}
	
}
