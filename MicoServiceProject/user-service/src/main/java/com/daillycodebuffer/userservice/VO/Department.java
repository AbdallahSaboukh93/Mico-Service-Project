package com.daillycodebuffer.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private Long deparmentId;
	private String deparmentName;
	private String deparmentAddress;
	private String deparmentCode;
}
