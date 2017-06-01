package cn.mobilemd.train.system.model.business;
import cn.mobilemd.train.common.PagerParamBase;


public class QueryCountryParam  extends PagerParamBase{
    private String countryname;

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
