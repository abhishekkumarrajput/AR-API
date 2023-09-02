package com.example.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppException {
	private String excode;
	private String exDesc;
	private LocalDateTime date;  //when we exception Occur
}
