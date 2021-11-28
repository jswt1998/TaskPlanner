package com.taskplanner.models;

import java.time.LocalDate;

public abstract class Task {
	private static int idCount = 0;
	
	private int id;
	private String title;
	private int createrId;
	private int assigneeId;
	private TaskType taskType;
	private LocalDate date;
	private String summary;
	private Status status;
	private int sprintId;
		
	
	public Task(String title, int createrId, int assigneeId, TaskType taskType, LocalDate date, String summary) {
		
		synchronized(Task.class) {
			  this.id =	idCount;
			  idCount++;
			}
		
		this.title = title;
		this.createrId = createrId;
		this.assigneeId = assigneeId;
		this.taskType = taskType;
		this.date = date;
		this.summary = summary;
		status = Status.OPEN;
		sprintId = -1;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the createrId
	 */
	public int getCreaterId() {
		return createrId;
	}
	/**
	 * @param createrId the createrId to set
	 */
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}
	/**
	 * @return the assigneeId
	 */
	public int getAssigneeId() {
		return assigneeId;
	}
	/**
	 * @param assigneeId the assigneeId to set
	 */
	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}
	/**
	 * @return the taskType
	 */
	public TaskType getTaskType() {
		return taskType;
	}
	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
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

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	
	
	
}
