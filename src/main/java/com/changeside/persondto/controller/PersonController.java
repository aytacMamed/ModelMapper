package com.changeside.persondto.controller;

import com.changeside.persondto.dto.PersonDTO;
import com.changeside.persondto.entities.Person;
import com.changeside.persondto.services.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personManager;

    @GetMapping
    public List<PersonDTO> getAll(){
        return personManager.people();
    }

    @GetMapping("/withPagination")
    public List<PersonDTO> getAllPagination(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return personManager.getAllPagination(page,count);
    }
    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Long id){
        return personManager.getByID(id);
    }
    @PostMapping
    public PersonDTO create(@RequestBody @Valid Person person){
     return personManager.create(person);
    }

    //swagger
}
