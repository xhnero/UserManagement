package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.dto.UserDto;

public class UserDelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			UserDao userDao = new UserDao();
			userDao.delUserById(id);
			List<UserDto> userDtos = userDao.getAllUser();
		     if(userDtos.size()>0){
		    	 request.setAttribute("userList",userDtos);
		    	 request.getRequestDispatcher("userDashboard.jsp").forward(request,reponse);
		     }
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
