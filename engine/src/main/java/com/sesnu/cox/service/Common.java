package com.sesnu.cox.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Common {
	
	private static final Logger mainL = LoggerFactory.getLogger("MainLog");
	
	@Autowired SimpMessagingTemplate wsMsgService;
	@Autowired DaoService daoService;
	private volatile List<JSONObject> logs;

	
	public Common (){
		logs = new ArrayList<JSONObject>();

	}

	
	
	
}
