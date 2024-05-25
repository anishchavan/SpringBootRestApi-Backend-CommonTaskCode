package edu.cjc.springbootrestapicrudapp.app.userserviceimpl;

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

}
