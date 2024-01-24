package com.nagarro.notes.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.notes.model.Note;
import com.nagarro.notes.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findOneByEmailAndPassword(String email, String Password);
	
	public User findOneByEmail(String email);
	
	//@Query(value = "SELECT N.TITLE, N.NOTE_TEXT FROM user_notes N, users U where U.user_id = N.user_user_id ORDER BY N.created_at LIMIT 10", nativeQuery = true)
	//public List<Note> getNotes(String email);
	
}
