package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
public class CategoryModel implements Model {
	// 		   request request
	// Controller = Model = JSP
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		FoodDAO dao=FoodDAO.newInstance();
//		System.out.println("controller:"+request);
		List<CategoryVO> list = dao.foodCategoryData();
		request.setAttribute("list", list);
		return "food/category.jsp";
	}

}
