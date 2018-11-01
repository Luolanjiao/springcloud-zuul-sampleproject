package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Thinkpad on 2018/10/30.
 */
@Component
public class MyFilter extends ZuulFilter
{
    private static Logger log= LoggerFactory.getLogger(MyFilter.class);
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
    public Object run() throws ZuulException {
        RequestContext rctx =RequestContext.getCurrentContext();
        HttpServletRequest request= rctx.getRequest();
        log.info("请求："+request.getRequestURL().toString()) ;
      Object token=  request.getParameter("token");
      if(token==null){
          log.warn("token is empty");
          rctx.setResponseStatusCode(401);
          rctx.setSendZuulResponse(false);
          try {
              rctx.getResponse().getWriter().write("token is empty");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      log.info("ok");
        return null;
    }
}
