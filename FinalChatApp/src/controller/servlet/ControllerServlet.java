package controller.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.handler.HandlerFactory;
import controller.handler.RequestHandler;
import domain.service.UserService;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	private HandlerFactory handlerFactory;
    public ControllerServlet() {
        super();
    }
    
    public void init() throws ServletException{
    	super.init();
    	ServletContext context = getServletContext();
    		service = new UserService();
    		Properties prop = new Properties();
    		try{
    		InputStream input = context.getResourceAsStream("/WEB-INF/handler.xml");
    		prop.loadFromXML(input);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    		handlerFactory = new HandlerFactory(prop,service);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String action = request.getParameter("action");
			RequestHandler handler = handlerFactory.getHandler(action);
			handler.handelRequest(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}