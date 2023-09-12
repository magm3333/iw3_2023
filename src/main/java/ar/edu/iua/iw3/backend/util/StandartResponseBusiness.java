package ar.edu.iua.iw3.backend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StandartResponseBusiness implements IStandartResponseBusiness {

	@Value("${dev.info.enabled:false}")
	private boolean devInfoEnabled;
	
	@Override
	public StandartResponse build(HttpStatus httpStatus, Throwable ex, String message) {
		StandartResponse sr=new StandartResponse(message, ex, httpStatus, devInfoEnabled);
		return sr;
	}

}
