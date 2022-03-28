package com.checkpointFiveBack.checkpointFiveBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.checkpointFiveBack.checkpointFiveBack.entity.Post;
import com.checkpointFiveBack.checkpointFiveBack.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	
	public List<Post> getProducts() {
		return postRepository.findAll();
	}
	
	public ResponseEntity<String> deletePost(Long id) {
	Post post = postRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	return new ResponseEntity<>("Post " + post.getTitle() + " deleted successfully !", HttpStatus.OK);
	}
	
	public void modifyPost(Post post, Long id) {
		Post existingPost = postRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		post.setTitle(existingPost.getTitle());
		post.setDescription(existingPost.getDescription());
		postRepository.save(post);
	}
	
	public ResponseEntity<String> createPost(Post post, Long id) {
		if (postRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Post already exists");
		}
		Post newPost = new Post();
		post.setTitle(post.getTitle());
		post.setDescription(post.getDescription());
		postRepository.save(post);
		return new ResponseEntity<>("Post " + post.getTitle() + " will be created successfully !", HttpStatus.OK);
	
	}
	
}
