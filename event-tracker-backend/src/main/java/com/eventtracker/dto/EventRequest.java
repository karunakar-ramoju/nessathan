package com.eventtracker.dto;

import java.util.Map;

public class EventRequest {

    private String event;
    private String sessionId;
    private String username;
    private String page;
    private Map<String, Object> metadata;

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getPage() { return page; }
    public void setPage(String page) { this.page = page; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
}
