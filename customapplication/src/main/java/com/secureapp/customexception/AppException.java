package com.secureapp.customexception;

public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMessage;
	private String exceptiontype;
	private String status;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExceptiontype() {
		return exceptiontype;
	}

	public void setExceptiontype(String exceptiontype) {
		this.exceptiontype = exceptiontype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AppException(int errorCode, String errorMessage, String exceptiontype, String status) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exceptiontype = exceptiontype;
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", exceptiontype="
				+ exceptiontype + ", status=" + status + "]";
	}

}
