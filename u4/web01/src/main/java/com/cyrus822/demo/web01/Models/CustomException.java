package com.cyrus822.demo.web01.Models;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class CustomException extends Exception {
    private String errId;
    private String errCode;
    private String errMsg;
    private Date errDateTime;
    private String rtnPath;

    public CustomException(String errCode, String errMsg, String rtnPath){
        this.errId = UUID.randomUUID().toString();
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errDateTime = new Date();
        this.rtnPath = rtnPath;
    }
}