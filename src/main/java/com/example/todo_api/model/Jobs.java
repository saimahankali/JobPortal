package com.example.todo_api.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobId;
	
	private String companyName;
	
	@Column(unique = true)
	private long companyId;
	
	private String role;
	private String eligibility;
	private String jobDescription;
	private String skillsRequired;
	private Date deadline;
	
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	
}
