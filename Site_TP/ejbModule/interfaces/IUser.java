package interfaces;

import entities.User_entity;

public interface IUser {

	public void addUser(User_entity user);
	public User_entity getUser(String email);
	
}
