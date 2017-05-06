package cn.mobilemd.train.system.dao;

import cn.mobilemd.train.system.model.business.CityBo;

/**
 * Created by yanjie.miao on 2017/5/3.
 */
public interface ICityDao {
    CityBo getCity(long id);
    int  createCity(CityBo city);
    int  modifyCity(CityBo city);
}
