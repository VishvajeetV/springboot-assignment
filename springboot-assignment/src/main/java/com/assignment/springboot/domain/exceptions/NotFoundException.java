package com.assignment.springboot.domain.exceptions;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends CustomException{
    private String msg;
    private Boolean success;
    private Integer code;

    public NotFoundException(String msg, Integer code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }
}
