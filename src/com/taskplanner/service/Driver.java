package com.taskplanner.service;

import java.time.LocalDate;

import com.taskplanner.models.Status;
import com.taskplanner.models.TaskType;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskPlannerService taskplanner = new TaskPlannerService();
		
		int userId1 = taskplanner.addUser("Rohan");
		int userId2 = taskplanner.addUser("Jaswanth");
		
		int taskId1 = taskplanner.addTask("Add logging", userId1, userId2, TaskType.STORY, LocalDate.of(2021, 12, 10), "none");
		int taskId2 = taskplanner.addTask("create a button", userId2, userId1, TaskType.FEATURE,LocalDate.of(2021, 10, 10), "none");
		
		int sprintId1 = taskplanner.createSprint();

		taskplanner.changeTaskStatus(taskId1, Status.OPEN);
		taskplanner.changeTaskStatus(taskId2, Status.COMPLETED);
		taskplanner.addSubTrack(taskId1, "check for profiling");
		taskplanner.addSubTrack(taskId2, "check the lag");
		taskplanner.addTaskSprint(taskId2, sprintId1);
		taskplanner.addTaskSprint(taskId1, sprintId1);
		
		
		taskplanner.displayUserAssignedTasks(userId2);
		taskplanner.displaySprint(sprintId1);
		
/*
		taskplanner.changeTaskStatus(taskId1, Status.COMPLETED);
		taskplanner.changeTaskStatus(taskId2, Status.COMPLETED);
		
		taskplanner.displayUserAssignedTasks(userId2);
		taskplanner.changeTaskStatus(taskId1, Status.OPEN);
		taskplanner.displaySprint(sprintId1);
		taskplanner.addSubTrack(taskId1, "Development");*/
	}

}
