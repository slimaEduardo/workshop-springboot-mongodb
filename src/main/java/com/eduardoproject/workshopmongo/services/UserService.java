package com.eduardoproject.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardoproject.workshopmongo.domain.User;
import com.eduardoproject.workshopmongo.dto.UserDTO;
import com.eduardoproject.workshopmongo.repository.UserRepository;
import com.eduardoproject.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not foud."));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new  User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
