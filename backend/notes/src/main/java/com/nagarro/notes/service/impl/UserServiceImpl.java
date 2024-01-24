package com.nagarro.notes.service.impl;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.notes.model.Note;
import com.nagarro.notes.model.User;
import com.nagarro.notes.repository.UserRepository;
import com.nagarro.notes.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return null;
		
		User user = userRepository.findOneByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("No user found");
		}
		return user;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		//return null;
		
		System.out.println(user);
		
		return userRepository.save(user);
	}

	@Override
	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findOneByEmailAndPassword(email, password);
	}

	@Override
	public boolean checkUser(String email) {
		// TODO Auto-generated method stub
		//return false;
		
		User user = userRepository.findOneByEmail(email);
		
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Note> getNotes(String email) {
		// TODO Auto-generated method stub
		//return null;
		
		//return userRepository.getNotes(email);
		
		User user = userRepository.findOneByEmail(email);
		
		//List<E> tail = l.subList(Math.max(l.size() - 3, 0), l.size());
		
		List<Note> notes = user.getNotes();
		List<Note> limitedNotes = notes.subList(Math.max(notes.size() - 10, 0), notes.size());
		
		return limitedNotes;
	}

	@Override
	public void addNote(Note note, String email) {
		// TODO Auto-generated method stub
		//return false;
		
		User user = userRepository.findOneByEmail(email);
		List<Note> notes = user.getNotes();
		
		notes.add(note);
		
		userRepository.save(user);		
	}

	@Override
	public void deleteNote(Note note, String email) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findOneByEmail(email);
		List<Note> notes = user.getNotes();
		System.out.println(notes);
		notes.remove(note);
		
		userRepository.save(user);
		
	}

//	@Override
//	public void deleteHourly() {
//		// TODO Auto-generated method stub
//		
//		int page=0;
//		Page<User> pageResult;
//		
//		do {
//			PageRequest pageRequest = PageRequest.of(page, 1);
//			pageResult = userRepository.findAll(pageRequest);
//			
//			for(User user: pageResult.getContent()) {
//				System.out.println(user);
//			}
//			
//			page++;
//		}while(pageResult.hasNext());
//		
//	}
	
	@Override
	public void deleteHourly() {
		//Query query = entityM
		List<User> userList = userRepository.findAll();
		
		for(User u: userList) {
			//System.out.println(u);
			//System.out.println(u.getNotes());
//			if(u.getNotes().size() > 10) {
//				
//			}
			
			while(u.getNotes().size() > 10) {
				//System.out.println(u.getNotes().size());
				u.delNote();
			}
			userRepository.save(u);
		}
	}
	
	
	
	
}
