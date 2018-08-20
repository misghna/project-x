package com.sesnu.cox.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class CoreService {
		private static final Logger mainL = LoggerFactory.getLogger("MainLog");
	 

	    @Autowired DaoService daoService;

	    private ScheduledExecutorService scheduler;

	    
	    public CoreService(){
	    	scheduler=Executors.newScheduledThreadPool(2);	    	
	    }
	    
	    
		@Scheduled(fixedRate=60000)
		public void init(){
			


		}
		

	    
		@PreDestroy
		public void cleanUp() throws Exception {

		}
}


