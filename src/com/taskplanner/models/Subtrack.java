package com.taskplanner.models;

public class Subtrack {
	private String title;
	private Status status;
	private static int idCount = 0;
	private int id;
	
	public Subtrack(String title) {
		synchronized(Subtrack.class) {
			  this.id =	idCount;
			  idCount++;
			}
		
		this.title = title;
		this.status = Status.OPEN;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
	
}
