package auctionKoi.project.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExceptionResponseDTO {
    private Date timeStamp;
    private int errorCode;
    private String message;
    private String stackTrace;
    private String exception;
}
