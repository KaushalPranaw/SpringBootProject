package com.app.demo.pojos;

public class Topic {

	private String id;
	private String name;
	private String desc;
	public Topic(String i, String name, String desc) {
		super();
		this.id = i;
		this.name = name;
		this.desc = desc;
	}
	public Topic() {
		super();
		System.out.println("in topic cust");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
}
