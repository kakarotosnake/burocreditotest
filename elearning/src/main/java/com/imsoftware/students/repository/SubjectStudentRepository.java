package com.imsoftware.students.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imsoftware.students.domain.SubjectStudentResultDTO;
import com.imsoftware.students.entity.SubjectStudent;

public interface SubjectStudentRepository extends JpaRepository<SubjectStudent, Integer> {

	@Query("Select new com.imsoftware.students.domain.SubjectStudentResultDTO(record.subjectId, count(record.subjectId)) "
			+ "From SubjectStudent record "
			+ "Group by record.subjectId")
	public List<SubjectStudentResultDTO> selectRecordsGroupBySubjectId();
}
