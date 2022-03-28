package com.checkpointFiveBack.checkpointFiveBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.checkpointFiveBack.checkpointFiveBack.dto.PostDto;
import com.checkpointFiveBack.checkpointFiveBack.entity.Post;
import com.checkpointFiveBack.checkpointFiveBack.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	
	public List<Post> getPost() {
		return postRepository.findAll();
	}
	
	public ResponseEntity<String> deletePost(Long id) {
	Post post = postRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	postRepository.deleteById(post.getId());
	return new ResponseEntity<>("Post " + post.getTitle() + " deleted successfully !", HttpStatus.OK);
	}
	
	public void modifyPost(PostDto postDto, Long id) {
		if (postRepository.existsByTitle(postDto.getTitle())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Post already exists");
		}
		Post existingPost = postRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		existingPost.setTitle(postDto.getTitle());
		existingPost.setDescription(postDto.getDescription());
		postRepository.save(existingPost);
	}
	
	public ResponseEntity<String> createPost(Post post) {
		Post newPost = new Post();
		newPost.setTitle(post.getTitle());
		newPost.setDescription(post.getDescription());
		postRepository.save(newPost);
		return new ResponseEntity<>("Post " + post.getTitle() + " will be created successfully !", HttpStatus.OK);
	
	}
	
}
