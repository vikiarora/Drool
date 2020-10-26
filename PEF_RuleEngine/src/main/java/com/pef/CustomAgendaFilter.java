package com.pef;

import java.util.Set;

import org.drools.core.spi.Activation;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class CustomAgendaFilter implements AgendaFilter{

	  private final Set<String> ruleNamesThatAreAllowedToFire;

	  public CustomAgendaFilter(Set<String> ruleNamesThatAreAllowedToFire){
	    this.ruleNamesThatAreAllowedToFire=ruleNamesThatAreAllowedToFire;
	    System.out.println(" Total applicable Rules = " + ruleNamesThatAreAllowedToFire.size());
	  }



	@Override
	public boolean accept(Match match) {
			  
		return ruleNamesThatAreAllowedToFire.contains(match.getRule().getName());
	}
	}
