package cn.mobilemd.train.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;


@JsonInclude(value = Include.NON_NULL)
public class ActionResult<T> extends  ActionResultBase{


    @ApiModelProperty(value = "结果数据data", required = false)
    private T data;

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
