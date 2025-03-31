package com.voicecall_springboot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.voicecall_springboot.json.JacksonLocalDateTimeDeserializer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class LoggedCallDto {

	private Integer id;
	@Schema(description = "Please enter the status")
	@NotEmpty(message = "Status should not be empty")
	private String status;
	@NotEmpty(message = " Phone Number should not be empty")
	@Schema(description = "Please enter the phone Number whom you want to call")
	private String toPhoneNumber;
	
	@JsonDeserialize(using = JacksonLocalDateTimeDeserializer.class)
	@Schema(description = "Please enter the local date time when the call is made")
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
	public LoggedCallDto(Integer id, @NotEmpty(message = "Status should not be empty") String status,
			@NotEmpty(message = " Phone Number should not be empty") String toPhoneNumber,
			@NotNull LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.status = status;
		this.toPhoneNumber = toPhoneNumber;
		this.localDateTime = localDateTime;
	}
	
}
