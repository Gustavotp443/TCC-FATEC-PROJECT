package com.project.sports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sports.entities.Sport;

public interface SportRepository extends JpaRepository<Sport, Long>{

}
