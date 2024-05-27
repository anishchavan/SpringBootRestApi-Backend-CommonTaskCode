package edu.cjc.springbootrestapicrudapp.app.userservice;

import java.util.List;

import edu.cjc.springbootrestapicrudapp.app.model.User;

public interface UserService {

	void saveDocument(User u);

	List<User> getDocument();

	List<User> deleteDocument(int uid);


}
