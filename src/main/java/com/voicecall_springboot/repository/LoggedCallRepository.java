package com.voicecall_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicecall_springboot.entity.LoggedCall;

public interface LoggedCallRepository extends JpaRepository<LoggedCall, Integer>{

}
