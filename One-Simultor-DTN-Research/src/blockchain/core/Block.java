package blockchain.core;

import java.util.ArrayList;
import java.util.List;

import core.DTNHost;

public class Block {

	
	public String previousHash;
	
	public String transactionId;
	
	public String messageId;
	
	public String fromWallet;
	
	public String toWallet;
	
	public String fromWalletCurrentGas;
	
	public String toWalletCurrentGas;
	
	public String time;

	public List<TransactionBlock> minorsTransaction=new ArrayList<>(); 
	
	
	



	public Block(String previousHash, String messageId, String fromWallet, String toWallet, String fromWalletCurrentGas,
			String toWalletCurrentGas, String time, List<TransactionBlock> minorsTransaction) {
		super();
		this.previousHash = previousHash;
		this.messageId = messageId;
		this.fromWallet = fromWallet;
		this.toWallet = toWallet;
		this.fromWalletCurrentGas = fromWalletCurrentGas;
		this.toWalletCurrentGas = toWalletCurrentGas;
		this.time = time;
		this.minorsTransaction = minorsTransaction;
		
		this.transactionId=calculateHash();
		DTNHost.BlockLastHash=this.transactionId;
	}

	public String calculateHash() 
    { 
        String calculatedhash 
            = Crypt.sha256( 
                previousHash 
                + time
                + messageId + fromWallet + toWallet); 
  
        return calculatedhash; 
    }

	@Override
	public String toString() {
		return "\n\nBlock [BlockpreviousHash=" + previousHash + ", BlockTransactionId=" + transactionId + ", messageId=" + messageId
				+ ", fromWallet=" + fromWallet + ", toWallet=" + toWallet + ", fromWalletCurrentGas="
				+ fromWalletCurrentGas + ", toWalletCurrentGas=" + toWalletCurrentGas + ", time=" + time
				+ ",\n minorsTransaction=" + minorsTransaction + "]";
	}

	
}
