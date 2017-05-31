package cn.mobilemd.train.system.model.dto;


import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yanjie.miao on 2017/5/27.
 */
public class CountryDto {

    @ApiModelProperty(value = "id")
    private Integer id;


    @ApiModelProperty(value = "名称")
    private String countryname;

    @ApiModelProperty(value = "代码")
    private String countrycode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
