package org.example.board.exception;

public enum ErrorCode {
  USER_NOT_FOUND(404, "등록된 사용자가 없습니다."),
  INVALID_PASSWORD(401, "비밀번호가 올바르지 않습니다.");

  private final int statusCode;
  private final String message;

  ErrorCode(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getMessage() {
    return message;
  }
}
