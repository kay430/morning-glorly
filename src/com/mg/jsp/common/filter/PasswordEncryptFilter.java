package com.mg.jsp.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.mg.jsp.common.wrapper.EncryptRequestWrapper;

@WebFilter(urlPatterns = {"/member/regist", "/member/findpwd"})
public class PasswordEncryptFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		EncryptRequestWrapper wrapper = new EncryptRequestWrapper(hrequest);

		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
					

			




				






