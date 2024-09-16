package auctionKoi.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@RestControllerAdvice

public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ExceptionResponseDTO handleException(Exception ex, WebRequest request){

        return ExceptionResponseDTO.builder()
                .timeStamp(new Date())
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .stackTrace(request.getDescription(false).replace("uri=",""))
                .exception(ex.getMessage())
                .build();
    }
}
