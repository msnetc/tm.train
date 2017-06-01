package cn.mobilemd.train.system.service;

import cn.mobilemd.train.common.PagerResult;
import cn.mobilemd.train.system.dao.CountryDao;
import cn.mobilemd.train.system.model.business.CountryBo;
import cn.mobilemd.train.system.model.business.QueryCountryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CountryService {

    @Autowired
    private CountryDao  countryDao;
    public CountryBo getById(Integer id) {
        return countryDao.getById(id);
    }

    public boolean deleteById(Integer id) {
         return countryDao.deleteById(id);
    }

    public boolean save(CountryBo country) {
        return countryDao.save(country);
    }

    public PagerResult<CountryBo> QueryCountrys(QueryCountryParam param){
        PagerResult<CountryBo> ret = new PagerResult<>();
        ret = countryDao.QueryCountrys(param);
        return ret;
    }

}
