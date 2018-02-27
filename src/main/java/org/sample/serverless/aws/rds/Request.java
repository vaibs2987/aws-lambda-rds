package org.sample.serverless.aws.rds;

public class Request {
	private int id;
	private String name;

	public Request() {
	}

	public Request(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Request{" + "id=" + id + ", name=" + name + '}';
	}
}
