package com.user.dao;

import com.user.dto.UserDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
	public List<UserDto> getAllUser() throws SQLException {
        List<UserDto> userDtos = null;
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/user?";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "xhnero131990");
            if (conn != null) {
                userDtos = new ArrayList<>();
                statement = conn.prepareStatement("SELECT  * FROM user");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    Date dob = resultSet.getDate("dob");
                    UserDto userDto = new UserDto(id, name, email, password, dob);
                    userDtos.add(userDto);
                }
            }

        } catch (Exception e) {
            return null;
        } finally {
            conn.close();
        }
        return userDtos;
    }
	public void insertUser(UserDto userDto) throws SQLException{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/user?";
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "xhnero131990");
            if (conn != null) {
                statement = conn.prepareStatement("insert into user(name,email,password,dob) values (?,?,?,?)");
                statement.setString(1,userDto.getName());
                statement.setString(2,userDto.getEmail());
                statement.setString(3,userDto.getPassword());
                statement.setDate(4, new java.sql.Date(userDto.getDob().getTime()));
                statement.executeUpdate();
            }

        } catch (Exception e) {
            return;
        } finally {
            conn.close();
        }
    }
	public void delUserById(Integer id) {
		 Connection conn = null;
	     String url = "jdbc:mysql://localhost:3306/user?";
	     PreparedStatement statement = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(url, "root", "xhnero131990");
	         if(conn!=null) {
	        	 statement = conn.prepareStatement("Delete from user where id = ?");
	        	 statement.setInt(1, id);
	        	 statement.execute();
	         }
	     }catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		UserDto userDto =null;
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/user?";
	     PreparedStatement statement = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(url, "root", "xhnero131990");
	         if(conn!=null) {
	        	 statement = conn.prepareStatement("Select * From user where id = ?");
	        	 statement.setInt(1, id);
	        	 ResultSet resultSet = statement.executeQuery();
	        	 while (resultSet.next()) {	
	                    String name = resultSet.getString("name");
	                    String email = resultSet.getString("email");
	                    String password = resultSet.getString("password");
	                    Date dob = resultSet.getDate("dob");
	                    userDto = new UserDto(id,name,email,password,dob);	                    
	                }
	         }
	     }catch (Exception e) {
			// TODO: handle exception
		}
	     return userDto;
	}
	public void updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/user?";
	     PreparedStatement statement = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(url, "root", "xhnero131990");
	         if(conn!=null) {
	        	 statement = conn.prepareStatement("Update user set name =?,email = ?, password = ?, dob=? where id = ?");
	        	 statement.setString(1, userDto.getName());
	        	 statement.setString(2, userDto.getEmail());
	        	 statement.setString(3, userDto.getPassword());
	        	 statement.setDate(4, new java.sql.Date(userDto.getDob().getTime()));
	        	 statement.setInt(5, userDto.getId());
	        	 statement.executeUpdate();
	         }
	     }catch (Exception e) {
			// TODO: handle exception
		}
	}
}
