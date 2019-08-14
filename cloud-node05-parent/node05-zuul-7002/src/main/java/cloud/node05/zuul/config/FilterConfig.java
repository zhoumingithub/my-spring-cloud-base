package cloud.node05.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class FilterConfig extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterConfig.class) ;
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext() ;
        try {
            doBizProcess(requestContext);
        } catch (Exception e){
            LOGGER.info("异常：{}",e.getMessage());
        }
        return null;
    }

    public void doBizProcess (RequestContext requestContext) throws Exception {
        HttpServletRequest request = requestContext.getRequest() ;
        String reqUri = request.getRequestURI() ;
        if (!reqUri.contains("getAuthorInfo")){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.getResponse().getWriter().print("Path Is Error...");
        }
    }
}
