package com.checkpointFiveBack.checkpointFiveBack.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkpointFiveBack.checkpointFiveBack.dto.PostDto;
import com.checkpointFiveBack.checkpointFiveBack.entity.Post;
import com.checkpointFiveBack.checkpointFiveBack.service.PostService;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostControler {

	@Autowired
	PostService postService;
	
	@PostMapping("/createPost")
	public ResponseEntity<String> createPost(@Valid Post post){
		return postService.createPost(post);
	}
	
	@GetMapping("/getPost")
	public List<Post> getPost() {
		return postService.getPost();
	}
	
	@GetMapping("/getOnePost/{id}")
	public Optional<Post> getOnePost(@PathVariable(required = true) Long id) {
		return postService.getOnePost(id);
	}
	
	
	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(required = true) Long id) {
		return postService.deletePost(id);
	}
	
	@PutMapping("/modifyPost/{id}")
	public void modifyCategory(@Valid PostDto postDto, @PathVariable Long id) {
		postService.modifyPost(postDto, id);
	}

	
}
