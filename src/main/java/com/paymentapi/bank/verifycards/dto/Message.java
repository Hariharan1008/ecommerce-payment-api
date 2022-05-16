package com.paymentapi.bank.verifycards.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Message {

	private String message;

	public Message(String message) {
		this.message = message;
	}
}