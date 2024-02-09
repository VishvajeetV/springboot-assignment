package com.assignment.springboot.domain.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class BadRequestException extends CustomException {

    private static final HttpStatus BADREQUEST_EXCEPTION_STATUS_CODE = HttpStatus.BAD_REQUEST;

    public BadRequestException(String errCode) {
        super(errCode);
        this.status = BADREQUEST_EXCEPTION_STATUS_CODE;
    }
    
    public String toString() {
        return String.format("Status : %s  message : %s errors : %s ",status.toString(), message, errors.toString());
    }
}