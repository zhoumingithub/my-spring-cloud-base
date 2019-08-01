package cloud.node02.consume.controller;

import cloud.node02.consume.tool.ReturnException;
import cloud.node02.consume.tool.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class HandlerException {
    /**
     * 自定义业务异常映射,返回JSON格式提示
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ReturnException handler01 (HttpServletRequest request, ServiceException e){
        ReturnException returnException = new ReturnException() ;
        returnException.setCode(500);
        returnException.setMsg(e.getMessage());
        return returnException ;
    }
}
