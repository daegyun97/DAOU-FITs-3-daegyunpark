package org.example.board.exception;

public class CustomException extends RuntimeException {

  private final int statusCode;

  public CustomException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.statusCode = errorCode.getStatusCode();
  }

  public int getStatusCode() {
    return statusCode;
  }
}