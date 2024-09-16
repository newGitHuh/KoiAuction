package auctionKoi.project.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

//model using to response data without paging
@Getter
public class SingleResponseModel<T> implements Serializable {
    private final int statusCode;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public SingleResponseModel(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public SingleResponseModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
