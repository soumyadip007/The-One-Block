package blockchain.core;

import core.DTNHost;

public class TransactionBlock {

	
	public String previousHash;
	
	public String transactionId;
	
	public String messageId;
	
	public String fromWallet;
	
	public String toWallet;
	
	public String fromWalletCurrentGas;
	
	public String toWalletCurrentGas;
	
	public String gas;
	
	public String time;

	
	
	
	public TransactionBlock(String previousHash, String messageId, String fromWallet, String toWallet,
			String fromWalletCurrentGas, String toWalletCurrentGas, String gas, String time) {
		super();
		this.previousHash = previousHash;
		this.messageId = messageId;
		this.fromWallet = fromWallet;
		this.toWallet = toWallet;
		this.fromWalletCurrentGas = fromWalletCurrentGas;
		this.toWalletCurrentGas = toWalletCurrentGas;
		this.gas = gas;
		this.time = time;

		this.transactionId=calculateHash() ;
		DTNHost.TransactionLastHash=this.transactionId;
	}



	public String calculateHash() 
    { 
        String calculatedhash 
            = Crypt.sha256( 
                previousHash 
                + time
                + messageId + fromWallet + toWallet + gas); 
  
        return calculatedhash; 
    }



	@Override
	public String toString() {
		return "Minors-TransactionBlock [previousHash=" + previousHash + ", transactionId=" + transactionId + ", messageId="
				+ messageId + ", fromWallet=" + fromWallet + ", toWallet=" + toWallet + ", fromWalletCurrentGas="
				+ fromWalletCurrentGas + ", toWalletCurrentGas=" + toWalletCurrentGas + ", gas=" + gas + ", time="
				+ time + "]\n";
	}


	
}
