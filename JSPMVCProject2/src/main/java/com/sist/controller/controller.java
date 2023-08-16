package com.sist.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.*;
//요청을 받는다 => 처리 클래스(Model)를 찾는다 => 처리한 결과값을 받는다
//결과값을 JSP로 전송한다
//----- session, request에 담아서 넘겨준다
//setAttribute() => 출력 (${})

@WebServlet("*.do") // URL주소는 언제든지 변경이 가능
// list.do => insert.do ... .do(controller를 호출)
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map clsMap=new HashMap();

	public void init(ServletConfig config) throws ServletException {
		clsMap.put("list.do", new ListModel());
		clsMap.put("insert.do", new InsertModel());
		clsMap.put("update.do", new UpdateModel());
		clsMap.put("delete.do", new DeleteModel());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI(); ///JSPMVCProject2/*.do
		cmd=cmd.substring(cmd.lastIndexOf("/")+1);
		//요청 확인
		//Model 클래스 => 처리
		Model model=(Model)clsMap.get(cmd);
		String jsp=model.excute(request, response);
		//request 전송
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
