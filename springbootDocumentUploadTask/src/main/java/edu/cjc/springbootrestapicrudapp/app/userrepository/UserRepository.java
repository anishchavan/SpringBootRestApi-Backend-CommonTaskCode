package edu.cjc.springbootrestapicrudapp.app.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.springbootrestapicrudapp.app.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
