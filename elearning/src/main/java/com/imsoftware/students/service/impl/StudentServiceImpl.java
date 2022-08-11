package com.imsoftware.students.service.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.imsoftware.students.repository.StudentRepository;
import com.imsoftware.students.repository.SubjectStudentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imsoftware.students.domain.StudentDTO;
import com.imsoftware.students.domain.SubjectStudentResultDTO;
import com.imsoftware.students.entity.Student;
import com.imsoftware.students.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	private final StudentRepository studentRepository;

	
	@Autowired
	private  SubjectStudentRepository subjectStudentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Collection<StudentDTO> findAll() {
		
	
		return studentRepository.findAll().stream().map(new Function<Student, StudentDTO>() {
			@Override
			public StudentDTO apply(Student student) {
				
				List<String> programmingLanguagesKnowAbout = student.getSubjects().stream()
						.map(pl -> new String(pl.getName())).collect(Collectors.toList());
				return new StudentDTO(student.getName(), programmingLanguagesKnowAbout);
			}

		}).collect(Collectors.toList());
		
	}

	@Override
	public Collection<StudentDTO> findAllAndShowIfHaveAPopularSubject() {
		// TODO Obtener la lista de todos los estudiantes e indicar la materia más concurrida existentes en la BD e
		// indicar si el estudiante cursa o no la materia más concurrida registrado en la BD.
		
		SubjectStudentResultDTO recordMax=subjectStudentRepository.selectRecordsGroupBySubjectId().stream().				
				max(Comparator.comparing(SubjectStudentResultDTO::getMaxResult )).orElse(new SubjectStudentResultDTO());
		
		
		
		return studentRepository.findAll().stream().map(new Function<Student, StudentDTO>() {
			@Override
			public StudentDTO apply(Student student) {
				List<Integer> programmingLanguagesKnowAbout = student.getSubjects().stream()
						.map(pl -> pl.getId()  ).collect(Collectors.toList());
				
				return new StudentDTO(student.getName(), programmingLanguagesKnowAbout.stream().
						anyMatch(r -> 
				          r ==recordMax.getSubjectId())  );
			}

		}).collect(Collectors.toList());
		
	}

}
