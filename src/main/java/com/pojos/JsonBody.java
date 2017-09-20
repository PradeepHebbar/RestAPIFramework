package com.pojos;

/**
 * @description : POJO with respect to body attributes
 * @author pradeep.jp
 *
 */
public class JsonBody {
	
	private int id;
	private String title;
	private String body;
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int postId) {
		this.userId = postId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String Title) {
		this.title = Title;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "[userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body
				+ "]";
	}
}
