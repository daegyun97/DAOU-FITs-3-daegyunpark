package org.example.board.exception;

import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


//@Provider
//public class GlobalExceptionHandler implements ExceptionMapper<CustomException> {
//  @Override
//  public Response toResponse(CustomException exception) {
//    System.out.println(exception.getMessage());
//    return Response.status(exception.getStatusCode())
//        .entity(new ErrorResponse(exception.getStatusCode(), exception.getMessage()))
//        .type(MediaType.APPLICATION_JSON)
//        .build();
//  }
//}
