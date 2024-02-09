package com.assignment.springboot.domain.exceptions;

import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidInputException extends Exception{
    private String msg;
    private Boolean success;
    private Integer code;

    public InvalidInputException(String msg, Integer code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public InvalidInputException(String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

}
