package com.sesnu.cox.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sesnu.cox.dao.TestDao;
import com.sesnu.cox.model.Tester;


@Service("daoService")
@Transactional
@SuppressWarnings({"unchecked","rawtypes"})
public class DaoServiceImpl implements DaoService{

	private static final Logger mainL = LoggerFactory.getLogger("MainLog");
	
	@Autowired TestDao tickerDao;
;

	public List<Tester> getAllTickers(){
		return tickerDao.findAll();
	}
	
	public List<Tester> getAllTickers(Set<String> tickerList){
		return tickerDao.findAll(tickerList);
	}
	
	
	public Tester getTicker(String tickerName){
		return tickerDao.findByName(tickerName);
	}
	
	public void saveTicker(Tester ticker){
		if(tickerDao.findByName(ticker.getName())==null){
			tickerDao.saveTicker(ticker);
		}else{
			tickerDao.updateTicker(ticker);
		}
	}
	

	@Override
	public void update(int orderId, double avgFillPrice) {
		// TODO Auto-generated method stub
		
	}

	
}
