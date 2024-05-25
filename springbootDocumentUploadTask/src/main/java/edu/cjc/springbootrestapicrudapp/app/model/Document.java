package edu.cjc.springbootrestapicrudapp.app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document implements Serializable {
	@Id
	private int did;
	@Lob
	@Column(length=876559656)
	private byte[] photo;
	@Lob
	@Column(length=876559665)
	private byte[] adharcard;
}
