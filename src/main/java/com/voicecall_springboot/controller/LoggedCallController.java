package com.voicecall_springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicecall_springboot.dto.LoggedCallDto;
import com.voicecall_springboot.entity.LoggedCall;
import com.voicecall_springboot.mapper.LoggedCallMapper;
import com.voicecall_springboot.service.LoggedCallService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("voicecall")
@RestController
@Slf4j
public class LoggedCallController {

	private LoggedCallService loggedCallService;
	private LoggedCallMapper loggedCallMapper =new LoggedCallMapper();

	@Autowired
	public LoggedCallController(LoggedCallService loggedCallService) {
		super();
		this.loggedCallService = loggedCallService;
	}
	@PostMapping("save")
	public ResponseEntity<LoggedCallDto> saveLoggedCall(@RequestBody @Valid LoggedCallDto loggedCallDto) {	
	
		LocalDateTime localDateTime = LocalDateTime.now();
		loggedCallDto.setLocalDateTime(localDateTime);
		LoggedCallDto savedLoggedCallDto  =	loggedCallService.saveCaller(loggedCallDto);
		return ResponseEntity.ok(savedLoggedCallDto);
	}
	@GetMapping("list")
	public ResponseEntity<List<LoggedCallDto>> getAll(){
		List<LoggedCallDto> list = loggedCallService.getAllList();
		return ResponseEntity.ok(list);
	}
	@GetMapping("list/{id}")
	public ResponseEntity<LoggedCallDto> getLoggedCallByIdentity(@PathVariable("id") Integer id){
		LoggedCallDto getCallerDetails = loggedCallService.getCallerById(id);
		return ResponseEntity.ok(getCallerDetails);
	}
	
}
