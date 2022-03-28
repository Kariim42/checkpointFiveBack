package com.checkpointFiveBack.checkpointFiveBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkpointFiveBack.checkpointFiveBack.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	boolean existsByTitle(String postTitle);
	
}
