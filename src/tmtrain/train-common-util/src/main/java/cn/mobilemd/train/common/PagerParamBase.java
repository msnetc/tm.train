package cn.mobilemd.train.common;


import io.swagger.annotations.ApiModelProperty;

public class PagerParamBase {

    @ApiModelProperty(value = "currentPageIndex")
    private int currentPageIndex ;

    @ApiModelProperty(value = "pageSize")
    private int pageSize;

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
