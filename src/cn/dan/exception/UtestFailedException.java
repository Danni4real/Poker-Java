package cn.dan.exception;


public class UtestFailedException extends RuntimeException {
	public UtestFailedException() {}
	public UtestFailedException(String detail) {
		super(detail);
	}
}

