package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessDomainFilter
 */

public class AccessDomainFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response1 = (HttpServletResponse) response;
		response1.setHeader("Access-Control-Allow-Origin", "*"); 
		response1.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");  
        response1.setHeader("Access-Control-Max-Age", "3600");  
        response1.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");  
        response1.setHeader("Access-Control-Allow-Credentials", "true"); 
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
