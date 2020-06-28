/*
 * author @Soumyadip
 */
package util;

/**
 * A generic key-value tuple 
 */
public class Carry<MsgId,Time>  {
	private MsgId key;
	private Time value;
	/**
	 * Creates a new tuple.
	 * @param key The key of the tuple
	 * @param value The value of the tuple
	 */
	public Carry(MsgId key, Time value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Carry() {
		super();
	}
	public MsgId getKey() {
		return key;
	}
	public void setKey(MsgId key) {
		this.key = key;
	}
	public Time getValue() {
		return value;
	}
	public void setValue(Time value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Carry [key=" + key + ", value=" + value + "]\n";
	}
	
}
