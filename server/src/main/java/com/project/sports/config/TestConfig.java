package com.project.sports.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.sports.entities.Address;
import com.project.sports.entities.Court;
import com.project.sports.entities.Institute;
import com.project.sports.entities.Sport;
import com.project.sports.entities.Student;
import com.project.sports.entities.Teacher;
import com.project.sports.entities.enums.Sports;
import com.project.sports.entities.enums.StudentLevel;
import com.project.sports.repositories.CourtRepository;
import com.project.sports.repositories.InstituteRepository;
import com.project.sports.repositories.SportRepository;
import com.project.sports.repositories.StudentRepository;
import com.project.sports.repositories.TeacherRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private CourtRepository courtRepository;
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	@Autowired
	private SportRepository sportRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Institute i1 = new Institute(null, "saojose@gmail.com", "123456", "Sao Jose", new Address("Rua santos",500,"09132-510","Santo","Santos","São Paulo"));
		instituteRepository.saveAll(Arrays.asList(i1));
		
		
		Court c1 = new Court(null, "Quadra principal", i1);
		courtRepository.saveAll(Arrays.asList(c1));
		
		Teacher t1 = new Teacher(null, "Joao", i1);
		teacherRepository.saveAll(Arrays.asList(t1));
		
		
		Student st1 = new Student(null, "Carlos", StudentLevel.Segundo_ano , "A" , i1);
		studentRepository.saveAll(Arrays.asList(st1));
		
		Sport sp1 = new Sport(null, Sports.Basquetebol, c1, t1);
		sportRepository.saveAll(Arrays.asList(sp1));
		
		sp1.addStudent(st1);
		sportRepository.saveAll(Arrays.asList(sp1));
		
		st1.addSport(sp1);
		studentRepository.saveAll(Arrays.asList(st1));
		
		
		
	}

}
