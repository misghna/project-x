package com.sesnu.cox.service;

import java.util.List;
import java.util.Set;

import com.sesnu.cox.model.Tester;

public interface DaoService {
	

	public List<Tester> getAllTickers();
	public List<Tester> getAllTickers(Set<String> tickerList);
	
	public Tester getTicker(String tickerName);
	public void saveTicker(Tester ticker);
	void update(int orderId, double avgFillPrice);
	
	


}