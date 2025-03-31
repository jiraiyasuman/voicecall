package com.voicecall_springboot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="logged_call")
@Data
public class LoggedCall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="status")
	private String status;
	@Column(name="to_phone_number")
	private String toPhoneNumber;
	@Column(name="local_date_time")
	private LocalDateTime localDateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public LoggedCall(Integer id, String status, String toPhoneNumber, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.status = status;
		this.toPhoneNumber = toPhoneNumber;
		this.localDateTime = localDateTime;
	}
	public LoggedCall() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoggedCall [id=" + id + ", status=" + status + ", toPhoneNumber=" + toPhoneNumber + ", localDateTime="
				+ localDateTime + "]";
	}
	
}
