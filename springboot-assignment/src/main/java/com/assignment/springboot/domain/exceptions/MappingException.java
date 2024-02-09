package com.assignment.springboot.domain.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class MappingException extends CustomException {

    private static final HttpStatus MAPPING_EXCEPTION_STATUS_CODE = HttpStatus.BAD_REQUEST;

    public MappingException(String errCode) {
        super(errCode);
        this.status = MAPPING_EXCEPTION_STATUS_CODE;
    }

    public String toString() {
        return String.format("Status : %s  message : %s errors : %s ",status.toString(), message, errors.toString());
    }
}