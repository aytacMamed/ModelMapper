package com.changeside.persondto.manager;

import com.changeside.persondto.config.mapperConfig.ModelMapperConfig;
import com.changeside.persondto.dto.PersonDTO;
import com.changeside.persondto.entities.Person;
import com.changeside.persondto.exception.PersonNotFoundException;
import com.changeside.persondto.repository.PersonRepository;
import com.changeside.persondto.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonManager implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(PersonManager.class);
    private final PersonRepository personRepository; //Inject-DI(dependency Injection)
    private final ModelMapper modelMapper;

    @Override
    public List<PersonDTO> people() {  //person->personDTO list`
        logger.info("Fetching all students");
        return personRepository.findAll().stream().
                map(person -> modelMapper.map(person, PersonDTO.class)).toList();
    }

    @Override
    public List<PersonDTO> getAllPagination(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Person> personPage = personRepository.findAll(pageable);
        return personPage.getContent().stream().map(person -> modelMapper.map(person, PersonDTO.class)).toList();
    }

    @Override
    public PersonDTO getByID(Long id) {
        logger.info("Fetching student by ID: {}", id);
        return personRepository.findById(id).stream(). //Optional<Person>->PersonDTO       Optional<PersonDTO>
                map(person -> modelMapper.map(person, PersonDTO.class)).findFirst().
                orElseThrow(() -> new PersonNotFoundException("person not found with id " +id));
    }

    @Override
    public PersonDTO create(Person person) { //person->personDTO
        personRepository.save(person);
        logger.info("Creating student: {}", person.getName());
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        return personDTO;
    }
}
