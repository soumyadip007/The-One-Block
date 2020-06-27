/*
 * author @Soumyadip
 */
package util;

/**
 * A generic key-value tuple 
 */
public class Delivered<MsgId,Time,From,To>  {
	private MsgId key;
	private Time value;
	private From host;
	private To to;
	/**
	 * Creates a new tuple.
	 * @param key The key of the tuple
	 * @param value The value of the tuple
	 */
	public Delivered(MsgId key,Time value,From f,To t) {
		this.key = key;
		this.value = value;
		this.host=f;
		this.to=t;
	}

	public Delivered() {
		
	}

	/**
	 * Returns the key
	 * @return the key
	 */
	public MsgId getKey() {
		return key;
	}

	/**
	 * Returns the value
	 * @return the value
	 */
	public Time getValue() {
		return value;
	}

	public void setKey(MsgId key) {
		this.key = key;
	}

	public void setValue(Time value) {
		this.value = value;
	}

	public From getHost() {
		return host;
	}

	public void setHost(From host) {
		this.host = host;
	}

	public To getTo() {
		return to;
	}

	public void setTo(To to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Deliverd-Message [Msg key=" + key + ",Time value=" + value + ", host=" + host + ", to=" + to + "]\n\n";
	}


	/**
	 * Returns a string representation of the tuple
	 * @return a string representation of the tuple
	 */
	
}
