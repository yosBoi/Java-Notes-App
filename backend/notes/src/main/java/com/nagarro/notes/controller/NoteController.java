package com.nagarro.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notes.config.JwtUtils;
import com.nagarro.notes.model.Note;
import com.nagarro.notes.service.UserService;

@RestController
@RequestMapping("/notes")
@CrossOrigin("*")
public class NoteController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/get")
	public List<Note> getNotes(@RequestHeader("Authorization") String token){
		//System.out.println(token);
		//String token2 = token.substring(7);
		//System.out.println(token2);
		//System.out.println(jwtUtils.extractEmail(token2));
		
		String jwtTokenString = token.substring(7);
		
		String email = jwtUtils.extractEmail(jwtTokenString);
		
		return userService.getNotes(email);
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity addNote(@RequestHeader("Authorization") String token, @RequestBody Note note) {
		
		String jwtTokenString = token.substring(7);
		String email = jwtUtils.extractEmail(jwtTokenString);
		userService.addNote(note, email);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PostMapping("/delete")
	public ResponseEntity deleteNote(@RequestHeader("Authorization") String token, @RequestBody Note note) {
		System.out.println(note);
		String jwtTokenString = token.substring(7);
		String email = jwtUtils.extractEmail(jwtTokenString);
		
		userService.deleteNote(note, email);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
