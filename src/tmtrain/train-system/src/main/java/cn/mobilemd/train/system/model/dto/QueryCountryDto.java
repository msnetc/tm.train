package cn.mobilemd.train.system.model.dto;

import cn.mobilemd.train.common.PagerParamBase;
import io.swagger.annotations.ApiModelProperty;

public class QueryCountryDto  extends PagerParamBase{

    @ApiModelProperty(value = "名称")
    private String countryname;

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
