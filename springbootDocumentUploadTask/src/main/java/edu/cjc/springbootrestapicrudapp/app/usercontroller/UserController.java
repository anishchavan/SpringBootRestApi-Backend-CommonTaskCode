package edu.cjc.springbootrestapicrudapp.app.usercontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cjc.springbootrestapicrudapp.app.model.Document;
import edu.cjc.springbootrestapicrudapp.app.model.User;
import edu.cjc.springbootrestapicrudapp.app.userservice.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
		
		@PostMapping(value = "/saveDocument", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
		public ResponseEntity<String> saveDocument(@RequestPart("photo") MultipartFile ph, @RequestPart("adharcard") MultipartFile ac, @RequestPart("jsondata")String json) throws IOException{
//			System.out.println("size: " + file.getSize());
//			System.out.println("filename: " + file.getName());
//			System.out.println("filetype: " + file.getContentType());
			System.out.println("byte: " + ph.getBytes());
			System.out.println(json);
			//Converting json data to object and vice versa
			
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);
			Document d = u.getD();
			d.setPhoto(ph.getBytes());
			d.setAdharcard(ac.getBytes());
			System.out.println(u);
			
			us.saveDocument(u);
			return new ResponseEntity<String>("file uploaded..", HttpStatus.OK);
		}
		
		@GetMapping("/getDocument")
		public ResponseEntity<List<User>> getDocument(){
			List<User> uList = us.getDocument();
			return new ResponseEntity<List<User>>(uList, HttpStatus.OK);
		}
		
		@PutMapping(value="/updateDocument/{uid}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
		public ResponseEntity<User> updateDocument(@PathVariable int uid,@RequestPart("photo") MultipartFile ph, @RequestPart("adharcard") MultipartFile ac, @RequestPart("jsondata")String json) throws IOException{
			
			ObjectMapper om = new ObjectMapper();
			User user = om.readValue(json, User.class);
			Document d = user.getD();
			d.setPhoto(ph.getBytes());
			d.setAdharcard(ac.getBytes());
			user.setD(d);
			us.saveDocument(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteDocument/{uid}")
		public ResponseEntity<List<User>> deleteDocument(@PathVariable int uid){
			List<User> uList = us.deleteDocument(uid);
			return new ResponseEntity<List<User>>(uList, HttpStatus.OK);
		}
}
