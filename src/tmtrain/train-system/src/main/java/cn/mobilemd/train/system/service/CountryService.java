package cn.mobilemd.train.system.service;

import cn.mobilemd.train.system.dao.CountryDao;
import cn.mobilemd.train.system.model.business.CountryBo;
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
}
