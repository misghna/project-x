package com.sesnu.cox.dao;

import java.util.List;
import java.util.Set;

import com.sesnu.cox.model.Tester;


public interface TestDao {

	List<Tester> findAll();
	List<Tester> findAll(Set<String> tickerList);
	Tester findByName(String name);
	
	public Tester findLastOne();
	
	public void updateTicker(Tester ticker);
	
	public void saveTicker(Tester ticker);
	
	public void updateTickerVolPerc(String tickerName,double volPerc);
	
}
