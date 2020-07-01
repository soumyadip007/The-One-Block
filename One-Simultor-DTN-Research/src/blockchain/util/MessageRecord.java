package blockchain.util;

import java.util.Set;
import java.util.TreeSet;

public class MessageRecord {


	public String from;
	
	public String to;
	
	public boolean recieved;
	
	public Set<String> carry=new TreeSet<>();
	
	public MessageRecord() {
		super();
	}

	@Override
	public String toString() {
		return "MessageRecord [from=" + from + ", to=" + to + ", recieved=" + recieved + ", carry=" + carry + "]\n";
	}

	public MessageRecord(String from, String to, boolean recieved) {
		super();
		this.from = from;
		this.to = to;
		this.recieved = recieved;
	}
	
	
	
}
