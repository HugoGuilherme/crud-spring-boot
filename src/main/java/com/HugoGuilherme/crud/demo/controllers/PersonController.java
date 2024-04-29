package com.HugoGuilherme.crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HugoGuilherme.crud.demo.data.vo.v1.PersonVO;
import com.HugoGuilherme.crud.demo.model.Person;
import com.HugoGuilherme.crud.demo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personService;

	@GetMapping(value = "/")
	public List<PersonVO> findAll() throws Exception {

		return personService.findAll();
	}

	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {

		return personService.findById(id);
	}

	@PostMapping(value = "/")
	public PersonVO create(@RequestBody PersonVO person) {

		return personService.create(person);
	}

	@PutMapping(value = "/{id}")
	public PersonVO update(@RequestBody PersonVO person, @PathVariable Long id) {

		return personService.update(person, id);
	}

	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable("id") Long id) throws Exception {
		personService.remove(id);
		return;
	}
}