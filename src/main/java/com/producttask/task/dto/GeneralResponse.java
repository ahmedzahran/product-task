package com.producttask.task.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
@Builder
public class GeneralResponse implements Serializable {

    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    private Integer code;
    private String message;
//    private Integer total;
    private Object data;

    public GeneralResponse() {}

    public GeneralResponse(int code, String message) {
        this.code = code;
        this.message = message;
//        this.total = 0;
        this.data = new Object[]{};
    }

    public GeneralResponse(int code, String message,Object o) {
        this.code = code;
        this.message = message;
//        this.total = 0;
        this.data = o;
    }
    public ResponseEntity<GeneralResponse> response(Object data) {
        this.code = 200;
        this.message = "Operation Success";
//        this.total = 1;
        this.data = data;

        return new ResponseEntity<GeneralResponse>(this,HttpStatus.OK);

    }

}
