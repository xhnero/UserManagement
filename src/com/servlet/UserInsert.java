package com.servlet;
import com.user.dao.UserDao;
import com.user.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
public class UserInsert extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            UserDao userDao = new UserDao();
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String date = req.getParameter("dob");
            Date dob = format.parse(date);
            String edit = req.getParameter("isUpdate");
            UserDto userDto = new UserDto();
            String id = req.getParameter("id");
            String alert = "";
            userDto.setName(name);
            userDto.setEmail(email);
            userDto.setPassword(password);
            userDto.setDob(dob);
            if(id==null|| id=="")
            {
            	userDao.insertUser(userDto);
            	alert = "User have been inserted successfully";
            }
				
            	
			else {
            	userDto.setId(Integer.parseInt(id));
            	userDao.updateUser(userDto);
            	alert = "User have been updated successfully";
            }
            List<UserDto> userDtos = userDao.getAllUser();
            if(userDtos.size()>0){
            	req.setAttribute("msg",alert);
                req.setAttribute("userList",userDtos);
                req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            return;
        }

    }
}
