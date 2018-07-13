package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TodoDao dao = new TodoDao();
		List<TodoDto> dtos = new ArrayList(); 
		List<TodoDto>[] todolists = new ArrayList[3];
		
		for(int i=0;i<3;i++)
		{
			todolists[i] = new ArrayList<TodoDto>();
		}
		
		
		dtos = dao.getTodos();
		
		for(int i=0; i< dtos.size();i++)
		{
			if(dtos.get(i).getTitle().equals("TODO"))
			{
				int todoadd=0;
				todolists[0].add(dtos.get(i));
			}
			else if(dtos.get(i).getTitle().equals("DOING"))
			{
				todolists[1].add(dtos.get(i));
			}
			else {
				todolists[2].add(dtos.get(i));
			}
		}
		
		//long a= 3;
		//TodoDto tempdto = new TodoDto(a,"테스트","2018-07-12 20:00:00",1,"타이틀","상태");
		
		
		//dao.addTodo(tempdto);
		
		req.setAttribute("dtos", dtos);
		req.setAttribute("todolists", todolists);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.jsp");
		requestDispatcher.forward(req, resp);
	
	}

}
