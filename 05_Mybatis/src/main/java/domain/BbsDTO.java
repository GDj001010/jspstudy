package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data = 여러가지 에너테이션(get, set, toString, ....) 을 가져옴
@Data

@NoArgsConstructor
@AllArgsConstructor

public class BbsDTO {
	private int bbsNo;
	private String title;
	private String content;
	private String modifiedDate;
	private String createdDate;
}
