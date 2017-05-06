package cn.mobilemd.train.system.service;

import cn.mobilemd.train.system.model.business.CityBo;

public interface ICityService {
    CityBo getCity(long id);

    int createCity(CityBo city);
}
