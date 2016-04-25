package com.rgabay.jfuture.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HnStory {

	private String by;
	private String descendants;
	private String score;
	private String time;
	private String title;
	private String type;
	private String url;
	
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getDescendants() {
		return descendants;
	}
	public void setDescendants(String descendants) {
		this.descendants = descendants;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	 @Override
	    public String toString() {
		 String jsonStr = "";
		 ObjectMapper mapper = new ObjectMapper();
		 
		 try {
			jsonStr = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 	return jsonStr;
	    }
}
