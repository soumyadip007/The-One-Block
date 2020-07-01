/*
 * author @Soumyadip
 */
package blockchain.util;

/**
 * A generic key-value tuple 
 */
public class WillReceive<MsgId,Time,From,To,Received>  {
	private MsgId key;
	private Time value;
	private From host;
	private To to;
	private Received rev;
	/**
	 * Creates a new tuple.
	 * @param key The key of the tuple
	 * @param value The value of the tuple
	 */
	public WillReceive(MsgId key,Time value,From f,To t,Received r) {
		this.key = key;
		this.value = value;
		this.host=f;
		this.to=t;
		this.rev=r;
	}

	public WillReceive() {
		
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

	public Received getRev() {
		return rev;
	}

	public void setRev(Received rev) {
		this.rev = rev;
	}

	@Override
	public String toString() {
		return "WillReceive-Message [key=" + key + ", value=" + value + ", host=" + host + ", to=" + to + ", rev=" + rev + "]\n";
	}



	/**
	 * Returns a string representation of the tuple
	 * @return a string representation of the tuple
	 */
	
}
