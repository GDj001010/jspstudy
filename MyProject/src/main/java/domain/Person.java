package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Person {
	
	private int personNo;
	private String name;
	private int age;
	private String gender;
	private Date modifiedDate;
	private Date createdDate;

}
