package cn.mobilemd.train.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;


@JsonInclude(value = Include.NON_NULL)
public class ActionResult<T> {

    @ApiModelProperty(value = "返回编码", required = true)
    private int code ;

    @ApiModelProperty(value = "结果数据data", required = false)
    private T data;

    @ApiModelProperty(value = "信息", required = false)
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
