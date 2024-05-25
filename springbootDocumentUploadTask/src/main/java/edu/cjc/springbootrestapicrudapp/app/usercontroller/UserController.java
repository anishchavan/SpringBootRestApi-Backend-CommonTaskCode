package edu.cjc.springbootrestapicrudapp.app.usercontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
