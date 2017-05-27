package cn.mobilemd.train.system.api;

import cn.mobilemd.train.common.ActionResult;
import cn.mobilemd.train.system.model.business.CountryBo;
import cn.mobilemd.train.system.service.CountryService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryApi {

    @Autowired
    private CountryService  countryService;

    @RequestMapping(value="/api/country/GetCountry/{id}", method= RequestMethod.GET )
    public ActionResult<CountryBo> GetCountry(@ApiParam("全局研究中心id") @PathVariable int id){
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
}
