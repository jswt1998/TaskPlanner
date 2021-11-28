package com.taskplanner.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Story extends Task{
	
	ArrayList<Subtrack> subTrackList;

	public Story(String title, int createrId, int assigneeId, LocalDate date, String summary) {
		super(title, createrId, assigneeId, TaskType.STORY, date, summary);
		subTrackList = new ArrayList<Subtrack>();
		// TODO Auto-generated constructor stub
	}
	
	public void addSubtrack(Subtrack subtrack) {
		
		if (super.getStatus() != Status.COMPLETED) {
			subTrackList.add(subtrack);
		}
		else {
			System.out.println("Failed to add subtrack");
		}
	}
	
	@Override
	public void setStatus(Status status){
		if (status != Status.TESTING) {
			super.setStatus(status);
		}
	}
	
	
	public void removeSubtrack(Subtrack subtrack) {
		
		if (super.getStatus() != Status.COMPLETED) {
			subTrackList.remove(subtrack);
		}
		else {
			System.out.println("Failed to add subtrack");
		}
	}

	/**
	 * @return the subTrackList
	 */
	public ArrayList<Subtrack> getSubTrackList() {
		return subTrackList;
	}
}
