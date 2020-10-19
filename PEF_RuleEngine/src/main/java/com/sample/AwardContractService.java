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

public class AwardContractService {

	public void applyAwardContractRules(ArrayList<Contract> contractList) {
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
}
