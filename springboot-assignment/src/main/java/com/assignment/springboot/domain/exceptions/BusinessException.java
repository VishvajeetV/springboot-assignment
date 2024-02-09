package com.assignment.springboot.domain.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class BusinessException extends CustomException {
  
    private static final HttpStatus BUSINESS_EXCEPTION_STATUS_CODE = HttpStatus.INTERNAL_SERVER_ERROR;
    
    public BusinessException(String errCode) {
        super(errCode);
        this.status = BUSINESS_EXCEPTION_STATUS_CODE;
    }
    
    public String toString() {
        return String.format("Status : %s  message : %s errors : %s ",status.toString(), message, errors.toString());
    }
}