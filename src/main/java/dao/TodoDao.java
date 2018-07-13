package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.TodoDto;

public class TodoDao {
	
	private static String url = "jdbc:mysql://localhost:3306/todolist";
	private static String uid = "temp";
	private static String upw = "temp";
	

	public TodoDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public int addTodo(TodoDto dto) {
		
		int insertCount = 0;
		
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into todo(title, name, sequence) values(?,?,?)";
		
		try{
			connection = DriverManager.getConnection(url, uid, upw);
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, "테스트");
			ps.setString(2, "이름");
			ps.setInt(3, 1);
			
			insertCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return insertCount;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from todo";
			
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			while(rs.next())
			{
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String regdate = rs.getString(3);
				int sequence = rs.getInt(4);
				String title = rs.getString(5);
				String type = rs.getString(6);
				
				TodoDto dto = new TodoDto(id,name,regdate,sequence,title,type);
				dtos.add(dto); 
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(connection != null)
					connection.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			}catch(Exception e2)
			{
				e2.printStackTrace();
			}
			
		}
		return dtos;
	}

	public int updateTodo() {
		
		return 0;
	}
}
