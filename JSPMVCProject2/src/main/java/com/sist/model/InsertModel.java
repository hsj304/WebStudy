package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertModel implements Model {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "추가 기능!!");
		return "view/insert.jsp"; 
	}

}
