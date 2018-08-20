package com.sesnu.cox.service;

import org.json.simple.JSONObject;

public class WSMessage {
    private String content;

    @SuppressWarnings("unchecked")
	public WSMessage(String type,String name,String value) {
    	JSONObject jo = new JSONObject();
    	jo.put("type", type);
    	jo.put("name", name);
    	jo.put("value", value);
    	this.content = jo.toString();
//        this.content = key + "-" + value;
    }

    public String getContent() {
        return content;
    }
}
