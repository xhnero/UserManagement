package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.dto.UserDto;

public class UserEdit extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			UserDao userDao = new UserDao();
			UserDto userDto = userDao.getUserById(id);
			List<UserDto> userDtos = userDao.getAllUser();
	        if(userDtos.size()>0){
	        	request.setAttribute("userDto",userDto);
	        	request.setAttribute("isUpdate","1");
	        	request.setAttribute("userList",userDtos);
	        	request.getRequestDispatcher("userDashboard.jsp").forward(request,response);
	        }
		}catch(Exception e) {
			
		}
		
	}
}
