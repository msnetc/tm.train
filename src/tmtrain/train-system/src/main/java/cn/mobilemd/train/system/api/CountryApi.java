package cn.mobilemd.train.system.api;

import cn.mobilemd.train.common.ActionResult;
import cn.mobilemd.train.common.PagerActionResult;
import cn.mobilemd.train.common.PagerResult;
import cn.mobilemd.train.system.aop.ApiException;
import cn.mobilemd.train.system.model.business.CountryBo;
import cn.mobilemd.train.system.model.business.QueryCountryParam;
import cn.mobilemd.train.system.model.dto.CountryDto;
import cn.mobilemd.train.system.model.dto.QueryCountryDto;
import cn.mobilemd.train.system.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryApi {

    @Autowired
    private CountryService  countryService;

    @ApiOperation(value = "获取单个model")
    @RequestMapping(value="/api/country/GetCountry", method= RequestMethod.POST )
    public ActionResult<CountryBo> GetCity(@ApiParam("id") @RequestBody Integer id) throws ApiException {
        CountryBo item = countryService.getById(id);
        ActionResult<CountryBo> ret = new ActionResult<>();
        if(item != null){
            ret.setCode(200);
            ret.setData(item);
        }{
            ret.setCode(777);
        }
        return ret;
    }

    @ApiOperation(value = "删除单个model")
    @RequestMapping(value="/api/country/DeleteCountry", method= RequestMethod.POST )
    public ActionResult<Boolean> DeleteCountry(@ApiParam("id") @RequestBody Integer id)  throws ApiException{
        boolean result = countryService.deleteById(id);
        ActionResult<Boolean> ret = new ActionResult<>();
        ret.setData(result);
        return ret;
    }

    @ApiOperation(value = "保存单个model")
    @RequestMapping(value="/api/country/SaveCountry", method= RequestMethod.POST )
    public ActionResult<Boolean> SaveCountry(@ApiParam("country") @RequestBody CountryDto country) throws ApiException{
        CountryBo bo = new CountryBo();
        BeanUtils.copyProperties(country, bo);
        boolean result = countryService.save(bo);
        ActionResult<Boolean> ret = new ActionResult<>();
        ret.setData(result);
        return ret;
    }

    @ApiOperation(value = "查询model列表")
    @RequestMapping(value="/api/country/QueryCountrys", method= RequestMethod.POST )
    public PagerActionResult<CountryBo> QueryCountrys(@ApiParam("query") @RequestBody QueryCountryDto query) throws ApiException {
        PagerActionResult<CountryBo> ret = new PagerActionResult<CountryBo>();
        QueryCountryParam param = new QueryCountryParam();
        BeanUtils.copyProperties(query, param);
        PagerResult<CountryBo> result = countryService.QueryCountrys(param);
        ret.setTotalCount(result.getTotalCount());
        ret.setData(result.getData());
        ret.setCode(200);
        return ret;
    }
}