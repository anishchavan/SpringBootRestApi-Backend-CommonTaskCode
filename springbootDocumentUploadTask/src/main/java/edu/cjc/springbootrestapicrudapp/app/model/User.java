package edu.cjc.springbootrestapicrudapp.app.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	@Id
	private int uid;
	
	private String uname;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Document d;
}
