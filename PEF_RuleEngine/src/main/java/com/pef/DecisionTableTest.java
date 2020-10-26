package com.pef;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DecisionTableTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-dtables");

			// go !
			Message message = new Message();
			
			message.setMessage("Approved Availability Price"); 
			message.setStatus(Message.CHECK2);
			System.out.println(message);
			kSession.insert(message); 
			kSession.fireAllRules();
			
			System.out.println("\n\nSecond trial ..");
			System.out.println(message);
			kSession.insert(message); 
			kSession.fireAllRules();
			 
			/*
			 * message.setMessage("Availability Price"); message.setStatus(Message.CHECK);
			 * kSession.insert(message); kSession.fireAllRules();
			 */
			} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class Message {

		public static final int CHECK2 = 0;
		public static final int CHECK3 = 1;
		public static final int APPROVEDTENDER = 2;

		private String message;

		private int status;

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
		public String toString() {
			return this.message + " :: " + this.status;
		}

	}

}
