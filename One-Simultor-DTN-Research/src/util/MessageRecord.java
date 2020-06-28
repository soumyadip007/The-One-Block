package util;

import java.util.List;

public class MessageRecord {


	public String from;
	
	public String to;
	
	public boolean recieved;
	
	public List<String> carry;

	public MessageRecord(String from, String to, boolean recieved, List<String> carry) {
		super();
		this.from = from;
		this.to = to;
		this.recieved = recieved;
		this.carry = carry;
	}

	public MessageRecord() {
		super();
	}
	
	
}
