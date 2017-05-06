package cn.mobilemd.train.system.api;

import cn.mobilemd.train.common.ActionResult;
import cn.mobilemd.train.system.aop.ApiException;
import cn.mobilemd.train.system.model.business.CityBo;
import cn.mobilemd.train.system.model.dto.CityDto;
import cn.mobilemd.train.system.service.ICityService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityApi {

    @Autowired
    private ICityService cityService;

    @ApiOperation(value="获取某个城市信息")
    @RequestMapping(value="/api/city/getcity", method= RequestMethod.GET )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="id",dataType="Long",required=true,value="姓名",defaultValue="1")
    })
    public ActionResult<CityDto> GetCity(@ApiParam("id") @RequestParam(value = "id", required = true) Long id) throws ApiException {
         ActionResult<CityDto> response=new ActionResult<CityDto>();
        CityBo city = cityService.getCity(id);
        CityDto cityDto=CityBoToDto(city);
        if(city !=null){
            response.setData(cityDto);
            response.setCode(200);
            return response;
        };
        response.setMessage(String.format("没有id为 %s 的城市", id));
        response.setCode(415);
        return response;
    }

    @ApiOperation(value = "创建城市")
    @RequestMapping(value = "/api/city/createcity", method = RequestMethod.POST)
    @ApiResponses(value = { @ApiResponse(code = 405, message = "invalid input") })
    public int createCity(@ApiParam("城市对象") @RequestBody CityDto city)  throws ApiException {
        CityBo item = cityDtoToBo(city);
        int ret = cityService.createCity(item);
        return ret;
    }

    private CityBo cityDtoToBo(CityDto city) {

        CityBo dest = new CityBo();
        BeanUtils.copyProperties(city, dest);
        return dest;
    }

    private CityDto CityBoToDto(CityBo item){
        CityDto dest = new CityDto();
        BeanUtils.copyProperties(item, dest);
        return dest;
    }

}
