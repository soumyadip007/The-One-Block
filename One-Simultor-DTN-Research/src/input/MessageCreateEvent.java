/*
 * Copyright 2010 Aalto University, ComNet
 * Released under GPLv3. See LICENSE.txt for details.
 */
package input;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import core.DTNHost;
import core.Message;
import core.SimClock;
import core.World;
import util.Created;
import util.WillReceive;

/**
 * External event for creating a message.
 */
public class MessageCreateEvent extends MessageEvent {
	private int size;
	private int responseSize;
	public static World w;
	
	public static boolean master=false;
	public static boolean slave=false;
	
	public static float cooperator_dp;
	public static float isolator_dp;
	public static float exploiter_dp;
	public static int count=0;
	
	private final Logger LOGGER =Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		
	
	public static int timer=1000;
	/**
	 * Creates a message creation event with a optional response request
	 * @param from The creator of the message
	 * @param to Where the message is destined to
	 * @param id ID of the message
	 * @param size Size of the message
	 * @param responseSize Size of the requested response message or 0 if
	 * no response is requested
	 * @param time Time, when the message is created
	 */
	public MessageCreateEvent(int from, int to, String id, int size,
			int responseSize, double time) {
		super(from,to, id, time);
		this.size = size;
		this.responseSize = responseSize;
	}

	//--------------Get World @Soumyadip
	public static World getWorld()
	{
		return w;
	}
		
	/**
	 * Creates the message this event represents.
	 */

	//--------------Implementing Checking @Soumyadip
	//--------------Add CM, Dm, WR
	@Override
	public void processEvent(World world) {
		DTNHost to = world.getNodeByAddress(this.toAddr);
		DTNHost from = world.getNodeByAddress(this.fromAddr);
		this.w=world;

				
					System.out.print("Form------->"+from);
					
					System.out.println("To------>"+to);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					Created<String, Integer, String,String> cm=new Created<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					
					from.cm.add(cm);
					
					
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					
					to.wr.add(wr);
					

					System.out.println("DTNHost From -> Created-Message List"+from.cm);
					System.out.println("DTNHost From -> Deliverd-Message List"+from.dm);
					System.out.println("DTNHost From -> Will Receive "+from.wr);
					System.out.println("DTNHost Form -> Carry-Message List"+from.cr+"\n");
					
					System.out.println("DTNHost To ->  Created-Message List"+to.cm);
					System.out.println("DTNHost To -> Deliverd-Message List"+to.dm);
					System.out.println("DTNHost To -> Will Receive "+to.wr);
					System.out.println("DTNHost To -> Carry-Message List"+to.cr+"\n");

	
		
	
	
	}

	@Override
	public String toString() {
		return super.toString() + " [" + fromAddr + "->" + toAddr + "] " +
		"size:" + size + " CREATE";
	}
}


/*
 * 
 * 
 * Message Creation Checking
 * 
 * 
 * 
 	if(from.updated_name.equals(""))
		{
		
			if(from.name.contains("Cooperators"))
			{
				
					System.out.print("Form------->"+from);
					
					System.out.println("    To------>"+to);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				else if(to.name.contains("Exploiters") && from.name.contains("Exploiters") ){
					
					
					System.out.print("Form------->"+from);
					
					System.out.println("To------>"+to);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				
				else if( from.name.contains("Isolators") && to.name.contains("Isolators"))
				{
					
					System.out.print("Form------->"+from);
					
					System.out.println("To------>"+to);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				else if( from.name.contains("Isolators") && to.name.contains("Cooperators"))
				{
					
					System.out.print("Form------->"+from);
					
					System.out.println("To------>"+to);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
				}
			}
		else
		{
			if(from.updated_name.contains("Cooperators")){
					System.out.print("Form------->"+from);
					System.out.println("Converted Form------->"+from.updated_name);
					
					System.out.print("To------>"+to);
					System.out.println("Converted To------->"+to.updated_name);
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				else if(to.updated_name.contains("Exploiters") && from.updated_name.contains("Exploiters") ){
					System.out.print("Form------->"+from);
					System.out.println("Converted Form------->"+from.updated_name);
					
					System.out.print("To------>"+to);
					System.out.println("Converted To------->"+to.updated_name);	System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				
				else if( from.updated_name.contains("Isolators") && to.updated_name.contains("Isolators"))
				{
					System.out.print("Form------->"+from);
					System.out.println("Converted Form------->"+from.updated_name);
					
					System.out.print("To------>"+to);
					System.out.println("Converted To------->"+to.updated_name);
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
					
				}
				else if( from.updated_name.contains("Isolators") && to.updated_name.contains("Cooperators"))
				{
					
					System.out.print("Form------->"+from);
					System.out.println("Converted Form------->"+from.updated_name);
					
					System.out.print("To------>"+to);
					System.out.println("Converted To------->"+to.updated_name);
					
					System.out.println("---------------------------------------------------");
						
					Message m = new Message(from, to, this.id, this.size);
		
					System.out.println("MSG Id: "+this.id);
					
					m.setResponseSize(this.responseSize);
					from.createNewMessage(m);
					
					System.out.println("MSG Id: "+this.id);
					System.out.println("Msg Create time"+m.getCreationTime());
					System.out.println("Msg Receive time"+m.getReceiveTime());
					
					
					CM<String, Integer, String,String> cm=new CM<String,Integer, String,String>();
					cm.setKey(this.id);
					cm.setValue(SimClock.getIntTime());
					cm.setHost(from.name);
					cm.setTo(to.name);
					//System.out.println(cm);
					
					from.cm.add(cm);
					WillReceive<String, Integer, String,String,Boolean> wr=new WillReceive<String,Integer, String,String,Boolean>();
					wr.setKey(this.id);
					wr.setValue(SimClock.getIntTime());
					wr.setHost(String.valueOf(from.address));
					wr.setTo(to.name);
					wr.setRev(false);
					to.wr.add(wr);
					
					
					System.out.println("DTNHost From -> DM List"+from.dm);
					System.out.println("DTNHost From -> CM List"+from.cm);
					System.out.println("DTNHost From -> Will Receive "+from.wr+"\n");
					System.out.println("DTNHost To -> DM List"+to.dm);
					System.out.println("DTNHost To -> CM List"+to.cm);
					System.out.println("DTNHost To -> Will Receive "+to.wr+"\n");
				}
		}
	
	
 */






















/*

1.
//		Message m = new Message(from, to, this.id, this.size);
//		m.setResponseSize(this.responseSize);
//		from.createNewMessage(m);
//		System.out.print("Ressponse Size------->"+this.responseSize);always getting 0



		
//		DM<String, Integer> dm=new DM<String,Integer>();
//		dm.setKey(m.getId());
//		dm.setValue(SimClock.getIntTime());
//		from.dm.add(dm);
			//	to.cm.add(cm);
		









2.
//			if(master_slave==true){
//			System.out.println("Cooperators DP "+cooperator_dp);
//			System.out.println("Isolators DP "+isolator_dp);
//			System.out.println("Exploiters DP "+exploiter_dp);
//			}



 */

