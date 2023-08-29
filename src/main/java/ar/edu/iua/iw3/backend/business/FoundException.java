package ar.edu.iua.iw3.backend.business;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FoundException extends Exception {

	private static final long serialVersionUID = 1L;

	@Builder
	public FoundException(String message, Throwable ex) {
		super(message, ex);
	}
	
	@Builder
	public FoundException(String message) {
		super(message);
	}
	
	@Builder
	public FoundException(Throwable ex) {
		super(ex.getMessage(), ex);
	}
	
}
