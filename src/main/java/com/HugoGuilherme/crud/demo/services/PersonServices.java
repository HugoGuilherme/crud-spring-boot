package com.HugoGuilherme.crud.demo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HugoGuilherme.crud.demo.data.vo.v1.PersonVO;
import com.HugoGuilherme.crud.demo.mapper.DozerMapper;
import com.HugoGuilherme.crud.demo.model.Person;
import com.HugoGuilherme.crud.demo.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one person!");

		var entity = repository.findById(id).orElseThrow();

		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Creating one person!");

		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;
	}

	public PersonVO update(PersonVO person, Long id) {
		logger.info("Updating one person!");

		var entity = repository.findById(id).orElseThrow();

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;	}

	public void remove(Long id) {

		logger.info("Deleting one person!");

		repository.deleteById(id);
	}
}
