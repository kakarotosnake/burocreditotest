package com.imsoftware.students.domain;

public class SubjectStudentResultDTO {
	
	private Integer subjectId;
	private Long maxResult;
	
	
	
	
	public SubjectStudentResultDTO() {
		super();
	}




	public SubjectStudentResultDTO(Integer subjectId, Long maxResult) {
		super();
		this.subjectId = subjectId;
		this.maxResult = maxResult;
	}




	public Integer getSubjectId() {
		return subjectId;
	}




	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}




	public Long getMaxResult() {
		return maxResult;
	}




	public void setMaxResult(Long maxResult) {
		this.maxResult = maxResult;
	}




	
	
	
	

}
