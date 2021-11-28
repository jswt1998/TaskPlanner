package com.taskplanner.models;

import java.util.ArrayList;

public class Sprint {
	ArrayList<Integer> taskList;
	private static int idCount = 0;
	private int id;

	public Sprint() {
		synchronized(Sprint.class) {
			  this.id =	idCount;
			  idCount++;
			}
		
		taskList = new ArrayList<Integer>();
	}
	
	public void addTask(int taskId) {
		taskList.add(taskId);
	}
	
	public void removeTask(int taskId) {
		taskList.remove(taskId);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the taskList
	 */
	public ArrayList<Integer> getTaskList() {
		return taskList;
	}
	
	
}
