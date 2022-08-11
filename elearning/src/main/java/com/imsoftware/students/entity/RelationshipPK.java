package com.imsoftware.students.entity;

import java.io.Serializable;
import java.util.Objects;

public class RelationshipPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527998341881110537L;

	private Integer studentId;
	private Integer subjectId;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(studentId, subjectId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationshipPK other = (RelationshipPK) obj;
		return Objects.equals(studentId, other.studentId) && Objects.equals(subjectId, other.subjectId);
	}
	
	
	
	

	
	
    
  
}