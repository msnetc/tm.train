package cn.mobilemd.train.system.dao;

import cn.mobilemd.train.common.PagerResult;
import cn.mobilemd.train.system.mapper.CountryMapper;
import cn.mobilemd.train.system.model.business.CountryBo;
import cn.mobilemd.train.system.model.business.QueryCountryParam;
import cn.mobilemd.train.system.model.data.CountryDo;
import org.apache.ibatis.session.SqlSession;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class CountryDao {

    @Resource
    private SqlSession sqlSession;

    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private CountryMapper countryMapper;

    public CountryBo getById(Integer id) {
        CountryDo countryDo= countryMapper.selectByPrimaryKey(id);
        if(countryDo ==null) return null;
        CountryBo data = mapper.map(countryDo, CountryBo.class);
        return data;
    }

    public boolean deleteById(Integer id) {
        int cnt = countryMapper.deleteByPrimaryKey(id);
        return cnt>0;
    }

    public boolean save(CountryBo country) {
        CountryDo data = new CountryDo();
        BeanUtils.copyProperties(country, data);
        int cnt=0;
        if (country.getId() != 0) {
            cnt =countryMapper.updateByPrimaryKey(data);
        } else {
            cnt = countryMapper.insert(data);
        }
        return cnt>0;
    }

    public PagerResult<CountryBo> QueryCountrys(QueryCountryParam param){
        PagerResult<CountryBo> ret = new PagerResult<>();
        List<CountryBo>  data = sqlSession.selectList("QueryCountrys", param);
        Integer cnt =sqlSession.selectOne("QueryCountrysCnt", param);
        ret.setData(data);
        ret.setTotalCount(cnt);
        return ret;
    }
}
