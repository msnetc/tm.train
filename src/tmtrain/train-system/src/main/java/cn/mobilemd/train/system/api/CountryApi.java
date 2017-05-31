package cn.mobilemd.train.system.api;

import cn.mobilemd.train.common.ActionResult;
import cn.mobilemd.train.common.PagerActionResult;
import cn.mobilemd.train.system.model.business.CountryBo;
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
    @RequestMapping(value="/api/country/GetCountry/{id}", method= RequestMethod.POST )
    public ActionResult<CountryBo> GetCountry(@ApiParam("id") @PathVariable int id){
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
    @RequestMapping(value="/api/country/DeleteCountry/{id}", method= RequestMethod.POST )
    public ActionResult<Boolean> DeleteCountry(@ApiParam("id") @PathVariable int id){
        boolean result = countryService.deleteById(id);
        ActionResult<Boolean> ret = new ActionResult<>();
        ret.setData(result);
        return ret;
    }

    @ApiOperation(value = "保存单个model")
    @RequestMapping(value="/api/country/SaveCountry", method= RequestMethod.POST )
    public ActionResult<Boolean> SaveCountry(@ApiParam("country") @RequestBody CountryDto country){
        CountryBo bo = new CountryBo();
        BeanUtils.copyProperties(country, bo);
        boolean result = countryService.save(bo);
        ActionResult<Boolean> ret = new ActionResult<>();
        ret.setData(result);
        return ret;
    }

    @ApiOperation(value = "查询model列表")
    @RequestMapping(value="/api/country/QueryCountrys", method= RequestMethod.POST )
    public PagerActionResult<CountryBo> QueryCountrys(@ApiParam("query") @RequestBody QueryCountryDto query){
        PagerActionResult<CountryBo> ret = new PagerActionResult<CountryBo>();
        return ret;
    }
}