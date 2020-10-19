package com.sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;

import com.sample.contract.Contract;
import com.sample.contract.ReadContractJSON;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	ReadContractJSON rcj = new ReadContractJSON();
	private ArrayList<Contract> contractList = new ArrayList<Contract>();

	public void loadContractData() {
		rcj.readJSONFile();
		contractList = rcj.getContractList();
	}
	public void printContractData() {
	    Iterator<Contract> it = contractList.iterator();
	     while(it.hasNext()){
	    	 Contract currContract = (Contract) it.next();
	        System.out.println(currContract);
	     }
	}
	
	public void applyRules() {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
		
        	Set <String> strRules = new HashSet<String>();
        	//strRules.add("Rule_FilterByCity");
        	strRules.add("Rule_AllocateByPrice");
        	
    		AgendaFilter  caFilter = new  CustomAgendaFilter(strRules);
			KieSession kSession = kContainer.newKieSession("ksession-rules");
    	    Iterator<Contract> it = contractList.iterator();
    	    while(it.hasNext()){
    	    	Contract currContract = (Contract) it.next();
    	    	kSession.insert(currContract);
    	    	//Printing all contracts details
    	    	System.out.println(currContract);
   	     	}
			//kSession.insert(contractSet);
			kSession.fireAllRules(caFilter);
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
    public static final void main(String[] args) {
    	
    	DroolsTest drl = new DroolsTest();
    	drl.loadContractData();
    	//drl.printContractData();
    	drl.applyRules();
    }

    
    
    
    
    public static class Message {


		//Limit Variables
		public static final float MAX_CAPACITY = 82;
		public static final String cityPreferred = "London"; 
		
		//Transaction Varaibles
		public static   float  LEFT_CAPACITY = 0;

    }

    
    
}
