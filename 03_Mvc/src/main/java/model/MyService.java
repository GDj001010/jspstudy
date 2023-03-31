package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MyService {
	// public abstract 는 자동으로 된다. 
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}


