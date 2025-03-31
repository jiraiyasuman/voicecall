package com.voicecall_springboot.service.impl;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import com.voicecall_springboot.dto.LoggedCallDto;
import com.voicecall_springboot.entity.LoggedCall;
import com.voicecall_springboot.mapper.LoggedCallMapper;
import com.voicecall_springboot.repository.LoggedCallRepository;
import com.voicecall_springboot.service.LoggedCallService;

import jakarta.annotation.PostConstruct;
@Service
public class LoggedCallServiceImpl implements LoggedCallService{

	private Logger LOGGER = Logger.getLogger(getClass().getName());
	private LoggedCallMapper loggedCallMapper =new LoggedCallMapper();
	private LoggedCallRepository loggedCallRepository;
	
	private final String ACCOUNT_SID = "********";
    private final String AUTH_TOKEN = "*********";
    private final String FROM_PHONE_NUMBER = "+*********";
	@Autowired
	public LoggedCallServiceImpl( LoggedCallRepository loggedCallRepository) {
		super();
		this.loggedCallRepository = loggedCallRepository;
	}

	@Override
	public LoggedCallDto saveCaller(LoggedCallDto loggedCallDto) {
		LoggedCall loggedCall = loggedCallMapper.mapToLoggedCall(loggedCallDto);
		LoggedCall savedLoggedCall = loggedCallRepository.save(loggedCall);
		LoggedCallDto savedCallDto = loggedCallMapper.mapToLoggedCallDto(savedLoggedCall);
		return savedCallDto;
	}

	@Override
	public List<LoggedCallDto> getAllList() {
		List<LoggedCall> getAll = loggedCallRepository.findAll();
		return getAll.stream().map((l) -> loggedCallMapper.mapToLoggedCallDto(l)).collect(Collectors.toList());
	}

	@Override
	public LoggedCallDto getCallerById(Integer id) {
		LoggedCall loggedCall = loggedCallRepository.findById(id).get();
		makeCall(loggedCall.getToPhoneNumber());
		LoggedCallDto loggedCallDto= loggedCallMapper.mapToLoggedCallDto(loggedCall);
		
		return loggedCallDto;
	}

	@Override
	public void makeCall(String toPhoneNumber) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Call.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(FROM_PHONE_NUMBER),
                URI.create("http://demo.twilio.com/docs/voice.xml") // TwiML instructions for the call
        ).create();
		LOGGER.info("Call made successfully");
	}

}
