package com.HugoGuilherme.crud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HugoGuilherme.crud.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}