package com.project.sports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sports.entities.Court;

public interface CourtRepository extends JpaRepository<Court, Long>{

}
