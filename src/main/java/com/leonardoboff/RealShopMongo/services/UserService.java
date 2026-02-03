package com.leonardoboff.RealShopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoboff.RealShopMongo.domain.User;
import com.leonardoboff.RealShopMongo.dtos.UserDTO;
import com.leonardoboff.RealShopMongo.repository.UserRepository;
import com.leonardoboff.RealShopMongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id = " + id));
	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}

	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	 
}
