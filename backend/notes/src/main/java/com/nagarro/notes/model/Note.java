package com.nagarro.notes.model;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import net.bytebuddy.asm.Advice.This;

@Embeddable
public class Note {

	private String title;
	private String noteText;
	private LocalDateTime createdAt;
	public Note(String title, String noteText, LocalDateTime createdAt) {
		super();
		this.title = title;
		this.noteText = noteText;
		this.createdAt = createdAt;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Note [title=" + title + ", noteText=" + noteText + ", createdAt=" + createdAt + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		//return true;
		
		Note n2 = (Note) o;
//		System.out.println(this.title);
//		System.out.println(n2.title);
//		System.out.println(this.title.equals(n2.title));
		if(this.title.equals(n2.title) && this.noteText.equals(n2.noteText) && this.createdAt.equals(n2.createdAt)) {
			System.out.println("matched");
			return true;
		}
		else {
			System.out.println("unmatched");
			return false;
		}
	}
	
}
