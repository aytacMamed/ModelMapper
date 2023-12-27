package com.changeside.persondto.repository;

import com.changeside.persondto.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
