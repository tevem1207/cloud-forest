package controller;

import java.util.ArrayList;
import java.util.Arrays;

import model.dto.PostDTO;

public class Controller {
	public String getName() {
		return "황태희";
	}

	public ArrayList<PostDTO> getPostList() {
		ArrayList<PostDTO> p = new ArrayList<PostDTO>();
		p.add(new PostDTO(0, "제목", "내용", new ArrayList<String>()));
		p.add(new PostDTO(1, "제목1", "내용1", new ArrayList<String>()));
		p.add(new PostDTO(2, "제목2", "내용2", new ArrayList<String>()));
		return p;
	}

	public PostDTO getPost() {
		return new PostDTO(0, "제목", "내용", new ArrayList<String>());
	}
}
