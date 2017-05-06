package cn.mobilemd.train.system.aop;

import cn.mobilemd.train.common.ActionResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    private  final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ActionResult<String> jsonErrorHandler(HttpServletRequest req, ApiException e) throws Exception {
        ActionResult<String> r = new ActionResult<String>();
        String message =String.format("访问url:%s 时出现异常", req.getRequestURL().toString());
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData(message);

        String fullMessage = String.format("%s, 异常内容为 %s", message, e.getMessage());
        logger.error(fullMessage);
        return r;
    }

}

