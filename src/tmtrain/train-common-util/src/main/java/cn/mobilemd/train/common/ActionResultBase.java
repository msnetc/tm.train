package cn.mobilemd.train.common;

import io.swagger.annotations.ApiModelProperty;

public class ActionResultBase {

    @ApiModelProperty(value = "返回编码", required = true)
    private int code ;

    @ApiModelProperty(value = "信息", required = false)
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
