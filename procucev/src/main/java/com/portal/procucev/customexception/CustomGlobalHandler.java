package com.portal.procucev.customexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.portal.procucev.utils.ApplicationConstants;



@ControllerAdvice
public class CustomGlobalHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomGlobalHandler.class);

	@ExceptionHandler(AppException.class)
	protected ResponseEntity<Object> customexception(AppException request) {
		log.info(request.toString());
		return ResponseEntity.ok().body(request);
	}

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<AppException> handleValidationError(DataAccessException ex) {
		log.error("Database Exception : ", ex);
		AppException messageResponse = new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "DATA_ACCESS_ERROR",
				"Database Exception", ApplicationConstants.FAILURE);
		return ResponseEntity.ok().body(messageResponse);
	}

}
