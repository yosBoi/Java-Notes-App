package com.nagarro.notes.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nagarro.notes.model.Note;
import com.nagarro.notes.model.User;

public interface UserService extends UserDetailsService {

	public User addUser(User user);
	
	public User getUser(String email, String password);
	
	public boolean checkUser(String email);
	
	public List<Note> getNotes(String email);
	
	public void addNote(Note note, String email);
	
	public void deleteNote(Note note, String email);
	
	public void deleteHourly();
}
