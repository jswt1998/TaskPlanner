package com.taskplanner.models;

import java.time.LocalDate;

public class Feature extends Task{
	private ImpactType impactType;

	public Feature(String title, int createrId, int assigneeId, LocalDate date, String summary, ImpactType impactType) {
		super(title, createrId, assigneeId, TaskType.FEATURE, date,summary);
		this.impactType = impactType;
		// TODO Auto-generated constructor stub
	}

	public ImpactType getImpactType() {
		return impactType;
	}

	public void setImpactType(ImpactType impactType) {
		this.impactType = impactType;
	}
}
