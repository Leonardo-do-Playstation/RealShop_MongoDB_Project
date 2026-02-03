package com.leonardoboff.RealShopMongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoboff.RealShopMongo.domain.Post;
import com.leonardoboff.RealShopMongo.repository.PostRepository;
import com.leonardoboff.RealShopMongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado! Id = " + id));
	}
	 
}
