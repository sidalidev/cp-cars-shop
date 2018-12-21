package interfaces;

import entities.UserEntity;

public interface IUser {

	public void addUser(UserEntity user);
	public UserEntity getUser(String email);
	public UserEntity getUserById(Integer id);
	
}
