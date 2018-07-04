package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;
import com.user.dto.UserDto;
public class UserLogin extends HttpServlet {
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            UserDao userDao = new UserDao();
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            List<UserDto> userDtos = userDao.getAllUser();
            if(userDtos.size()>0){
                req.setAttribute("userList",userDtos);
                req.getRequestDispatcher("userDashboard.jsp").forward(req,resp);
            }
        } catch (Exception e) {

        }
		
       
    }
}
