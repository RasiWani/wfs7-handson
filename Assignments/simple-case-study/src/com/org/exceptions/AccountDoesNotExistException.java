package com.org.exceptions;

public class AccountDoesNotExistException extends Exception
{
	/**
	 * @param message
	 * @param cause
	 */
	public AccountDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AccountDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AccountDoesNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
