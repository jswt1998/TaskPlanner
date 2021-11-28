package com.taskplanner.models;

import java.util.ArrayList;

public class User {
	private static int idCount = 0;
	private int id;
	private String name;
	ArrayList<Integer> taskIds;
	
	public User(String name){
		
		synchronized(User.class) {
		  this.id =	idCount;
		  idCount++;
		}
		
		this.setName(name);
		taskIds = new ArrayList<Integer>();
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTask(int taskId) {
		taskIds.add(taskId);
	}
	
	public void removeTask(int taskId) {
		taskIds.remove(taskId);
	}

	/**
	 * @return the taskIds
	 */
	public ArrayList<Integer> getTaskIds() {
		return taskIds;
	}
	
	
}
