package com.taskplanner.service;

import java.time.LocalDate;
import java.util.HashMap;

import com.taskplanner.models.Feature;
import com.taskplanner.models.ImpactType;
import com.taskplanner.models.Sprint;
import com.taskplanner.models.Status;
import com.taskplanner.models.Story;
import com.taskplanner.models.Subtrack;
import com.taskplanner.models.Task;
import com.taskplanner.models.TaskType;
import com.taskplanner.models.User;

public class TaskPlannerService {
	
    HashMap<Integer, Sprint> sprints;
	HashMap<Integer, User>  users;
	HashMap<Integer, Task>  tasks;
	
	public TaskPlannerService(){
		users = new HashMap<Integer, User>();
		sprints = new HashMap<Integer, Sprint>();
		tasks       = new HashMap<Integer, Task>();
	}
	
	public int addUser(String name) {
		User user = new User(name);
		users.put(user.getId(), user);
		
		return user.getId();
	}
	
	public int addTask(String title, int createrId, int assigneeId, TaskType taskType, LocalDate date, String summary) {
		Task task;
		
		if (TaskType.FEATURE == taskType) {
			task = new Feature(title, createrId, assigneeId, date, summary, ImpactType.LOW);
		}
		else {
			task = new Story(title, createrId, assigneeId, date, summary);
		}
		
		tasks.put(task.getId(), task);
		users.get(assigneeId).addTask(task.getId());
		
		return task.getId();
	}
	
	public void changeTaskStatus(int taskId, Status status) {
		tasks.get(taskId).setStatus(status);
	}
	
	public void changeUser(int taskId, int userId) {
		users.get(tasks.get(taskId).getAssigneeId()).removeTask(taskId);
		tasks.get(taskId).setAssigneeId(userId);
		users.get(userId).addTask(taskId);
	}
	
	public void addSubTrack(int taskId, String Title) {
		if (tasks.get(taskId).getTaskType() == TaskType.STORY) {
			Story story = (Story)tasks.get(taskId);
			
			story.addSubtrack(new Subtrack(Title));
		}
	}
	
	public int createSprint() {
		Sprint s = new Sprint();
		sprints.put(s.getId(), s);
		
		return s.getId();
	}
	
	public void addTaskSprint(int taskId, int sprintId) {
		if (tasks.get(taskId).getSprintId() == -1){
			sprints.get(sprintId).addTask(taskId);
			tasks.get(taskId).setSprintId(sprintId);
		}		
	}
	
	public void removeTaskSprint(int taskId) {
		if (tasks.get(taskId).getSprintId() == -1){
			sprints.get(tasks.get(taskId).getSprintId()).removeTask(taskId);
			tasks.get(taskId).setSprintId(-1);
		}	
	}
	
	public void displayUserAssignedTasks(int userId) {
		
		System.out.println("UserName: " + users.get(userId).getName());
		
		System.out.println("Feature:");
		for (Integer taskId : users.get(userId).getTaskIds()) {
			if (tasks.get(taskId).getTaskType() == TaskType.FEATURE)
			{
				Feature feature = (Feature)tasks.get(taskId);
				System.out.println("Task Title "+ feature.getTitle());
				System.out.println("SprintId: " + feature.getSprintId());
			}
		}
		
		System.out.println("Story:");
		for (Integer taskId : users.get(userId).getTaskIds()) {
			if (tasks.get(taskId).getTaskType() == TaskType.STORY) {
				Story story = (Story)tasks.get(taskId);
				System.out.println("Task Title "+ story.getTitle());
				System.out.println("SprintId: " + story.getSprintId());
				
				System.out.println("Subtracks: ");
				for (Subtrack strack : story.getSubTrackList()) {
					System.out.println(strack.getTitle());
				}
			}
		}
	}
	
	public void displaySprint(int sprintId) {
		System.out.println("Sprint Id" + sprintId);
		
		System.out.println("On track tasks: ");
		for (Integer taskId : sprints.get(sprintId).getTaskList()) {
			Task task = tasks.get(taskId);
			if ((!task.getDate().isBefore(LocalDate.now())) ||
			    (task.getStatus() == Status.COMPLETED)){
			System.out.println("Task Title: "+ task.getTitle());
			}
		}
		
		System.out.println("Delayed tasks: ");
		for (Integer taskId : sprints.get(sprintId).getTaskList()) {
			Task task = tasks.get(taskId);
			if ((!task.getDate().isAfter(LocalDate.now())) &&
			    (task.getStatus() != Status.COMPLETED)){
			System.out.println("Task Title: "+ task.getTitle());
			}
		}
	}	
}
