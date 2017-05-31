package cn.mobilemd.train.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PagerResult<T> {
    @ApiModelProperty(value = "返回的数据列表")
    private List<T> data;

    @ApiModelProperty(value = "查询的结果总数")
    private int totalCount;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
