package cn.mobilemd.train.system.dao;

import cn.mobilemd.train.system.model.business.CityBo;
import cn.mobilemd.train.system.model.data.CityDo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class CityDao  implements  ICityDao {

    @Resource
    private SqlSession sqlSession;

    public CityBo getCity(long id) {

        CityDo city = this.sqlSession.selectOne("selectCityById", id);
        CityBo ret = ToBo(city);
        return ret;
    }

    public int createCity(CityBo city) {
        return this.sqlSession.insert("createCity", city);
    }

    public int modifyCity(CityBo city) {
        return this.sqlSession.update("modifycity", city);
    }

    private CityBo ToBo(CityDo city) {
        CityBo bo = new CityBo();
        BeanUtils.copyProperties(city, bo);
        return bo;
    }
}
