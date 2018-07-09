package edu.ecache;



public class Dog {
	
	private long height;
	private short age;
	private String name;
	public Dog(long height, String name, short age) {
		this.height=height;
		this.name=name;
		this.age=age;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+"-"+this.age+"-"+this.height;
	}
}
