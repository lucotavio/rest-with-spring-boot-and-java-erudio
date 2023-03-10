package br.com.luciano.exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime timestamp;
	private String message;
	private String details;

}
