package com.imsoftware.students.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "subject_student")
@IdClass(RelationshipPK.class)
public class SubjectStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3463345453424730813L;

	@Id
	@Column(name = "student_id")
	private Integer studentId;
	@Id
	@Column(name = "subject_id")
	private Integer subjectId;
	
	
	
	
}
