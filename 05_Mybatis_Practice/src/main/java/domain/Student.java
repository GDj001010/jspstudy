package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Student {

	private int stuNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double ave;
	private String grade;
	
	
	
}
