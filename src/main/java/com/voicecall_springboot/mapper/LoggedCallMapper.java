package com.voicecall_springboot.mapper;

import com.voicecall_springboot.dto.LoggedCallDto;
import com.voicecall_springboot.entity.LoggedCall;

public class LoggedCallMapper {

	public LoggedCall mapToLoggedCall(LoggedCallDto loggedCallDto) {
		LoggedCall loggedCall = new LoggedCall(
				loggedCallDto.getId(),
				loggedCallDto.getStatus(),
				loggedCallDto.getToPhoneNumber(),
				loggedCallDto.getLocalDateTime()
				);
		return loggedCall;
	}
	
	public LoggedCallDto mapToLoggedCallDto(LoggedCall loggedCall) {
		LoggedCallDto loggedCallDto = new LoggedCallDto(
				loggedCall.getId(), 
				loggedCall.getStatus(),
				loggedCall.getToPhoneNumber(),
				loggedCall.getLocalDateTime()
				);
		return loggedCallDto;
	}
}
