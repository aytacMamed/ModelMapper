package com.changeside.persondto.services;

import com.changeside.persondto.dto.PersonDTO;
import com.changeside.persondto.entities.Person;

import java.util.List;

public interface PersonService {
    List<PersonDTO> people();
    List<PersonDTO> getAllPagination(int page,int count);
    PersonDTO getByID(Long id);
    PersonDTO create(Person person);

}
