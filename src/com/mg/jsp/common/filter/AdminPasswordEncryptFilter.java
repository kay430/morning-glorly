package com.jihunh.jsp.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.jihunh.jsp.common.wrapper.EncryptRequestWrapper2;

@WebFilter("/admin/regist")
public class AdminPasswordEncryptFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		EncryptRequestWrapper2 wrapper = new EncryptRequestWrapper2(hrequest);

		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}














