package com.cyfrifpro.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetPasswordDTO {
	private String userId ;
	private String memberId ;
	private String password ;
	private String passKey ;
}
