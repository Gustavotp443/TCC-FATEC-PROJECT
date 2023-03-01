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
import com.project.sports.entities.Teacher;
import com.project.sports.entities.User;
import com.project.sports.entities.enums.Sports;
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
		
		Court c1 = new Court(null, "Quadra principal", i1);
		courtRepository.saveAll(Arrays.asList(c1));
		
		Teacher t1 = new Teacher(null, "Joao", i1);
		
		Sport s1 = new Sport(null, Sports.Basquetebol);
		s1.setCourt(c1);
		
		instituteRepository.saveAll(Arrays.asList(i1));
		
		
	}

}
