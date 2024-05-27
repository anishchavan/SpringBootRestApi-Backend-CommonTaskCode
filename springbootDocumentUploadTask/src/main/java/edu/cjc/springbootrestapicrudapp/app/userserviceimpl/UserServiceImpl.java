package edu.cjc.springbootrestapicrudapp.app.userserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.springbootrestapicrudapp.app.model.User;
import edu.cjc.springbootrestapicrudapp.app.userrepository.UserRepository;
import edu.cjc.springbootrestapicrudapp.app.userservice.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository ur;
	@Override
	public void saveDocument(User u) {
		ur.save(u);
		
	}
	@Override
	public List<User> getDocument() {
		return ur.findAll();
	}
	@Override
	public List<User> deleteDocument(int uid) {
		ur.deleteById(uid);
		return ur.findAll();
	}
	


}
