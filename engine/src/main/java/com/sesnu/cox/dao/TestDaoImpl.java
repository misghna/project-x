package com.sesnu.cox.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sesnu.cox.model.Tester;



@Repository("tickerDao")
@Transactional
public class TestDaoImpl extends AbstractDao<Integer, Tester>implements TestDao{

	public Tester findById(int id) {
		return getByKey(id);
	}

	public Tester findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Tester) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tester> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("ticker"));
		return (List<Tester>)crit.list();
	}
	
	public List<Tester> findAll(Set<String> tickerList){
		Criteria crit = createEntityCriteria();
		Disjunction disjunction = Restrictions.disjunction();
		for (String tickerStr : tickerList) {
			disjunction.add(Restrictions.or(Restrictions.eq("name", tickerStr)));
		}
		crit.add(disjunction);
		crit.addOrder(Order.asc("name"));
		return (List<Tester>)crit.list();
	}
	

	public Tester findLastOne(){
		Criteria crit = createEntityCriteria();
		crit.setMaxResults(1);
		crit.addOrder(Order.desc("updatedOn"));
		return (Tester)crit.list().get(0);
	}
	
	public void updateTicker(Tester ticker) {
		update(ticker);
	}
	
	public void saveTicker(Tester ticker) {
		save(ticker);
	}
	
	public void updateTickerVolPerc(String tickerName,double volPerc) {
		Tester ticker = findByName(tickerName);
	//	ticker.setPercent(volPerc);
		ticker.setUpdatedOn(System.currentTimeMillis());
		update(ticker);
	}
}
