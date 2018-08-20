package com.sesnu.cox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name="ticker")
public class Tester implements Serializable{
	
	
	public Tester(){}
	
	public Tester(String name){
		this.name=name;
		updatedOn = System.currentTimeMillis();
	}
	
	@Id
	@SequenceGenerator(name="ticker_seq",sequenceName="ticker_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ticker_seq")
	private Integer id;	

	private String name;
	
	@Column(name="avg_vol")
	private long avgVol;
	
	@Column(name="market_cap")
	private double marketCap;
	
	@Column(name="float_vol")
	private long floatVol;
	
	private String type;
	
	private String remark;
	
	@Column(name="updated_on")
	private long updatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAvgVol() {
		return avgVol;
	}

	public void setAvgVol(long avgVol) {
		this.avgVol = avgVol;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public long getFloatVol() {
		return floatVol;
	}

	public void setFloatVol(long floatVol) {
		this.floatVol = floatVol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(long updatedOn) {
		this.updatedOn = updatedOn;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString(){
		return "ticker:" + name + " marketCap:" + this.marketCap + " avgVol:" + this.avgVol + " floatShares:"+ this.floatVol + " type:" + this.type;
	}

	@SuppressWarnings("unchecked")
	public JSONObject toJson() {
		JSONObject jo = new JSONObject();
		jo.put("name", name);
		jo.put("marketCap", marketCap);
		jo.put("avgVol", avgVol);
		jo.put("floatShares", floatVol);
		jo.put("type", type);
		
		return jo;
	}
	
	
	


}
