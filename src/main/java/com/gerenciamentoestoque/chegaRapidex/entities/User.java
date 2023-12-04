package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("user")
public class User
{
//	@Transient
//	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	@Setter
	private Long userId;
	@Setter
	private String username;
	@Setter
	private String password;
	@Setter
	private String fullname;
}
