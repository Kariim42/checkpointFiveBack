package com.checkpointFiveBack.checkpointFiveBack.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostDto {

	@NotBlank
	@Size(min = 2, max = 100)
	private String title;

	@NotBlank
	@Size(min = 15, max = 4000)
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PostDto(String title, String description) {
		this.title = title;
		this.description = description;
	}
}
