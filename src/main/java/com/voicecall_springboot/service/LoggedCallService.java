package com.voicecall_springboot.service;

import java.util.List;

import com.voicecall_springboot.dto.LoggedCallDto;
import com.voicecall_springboot.entity.LoggedCall;

public interface LoggedCallService {

	public LoggedCallDto saveCaller(LoggedCallDto loggedCallDto);
	
	public List<LoggedCallDto> getAllList();
	
	public LoggedCallDto getCallerById(Integer id);
	
	public void makeCall(String toPhoneNumber);
	
	
}
