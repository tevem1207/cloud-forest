package model.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
	private int id;
	private String title;
	private String content;
	private ArrayList<String> commentList;
	
	public int getCommentCnt() {
		return commentList.size();
	}
}
