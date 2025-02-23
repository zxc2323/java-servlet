package ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import dao.HibernateUtil;
import dao.ListeCourseDAO;
import metier.ListeCourse;

/**
 * Servlet implementation class ctrlListCourse
 */
@WebServlet("/ListCourse")
public class ctrlListCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlListCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用HibernateUtil中已经创建的SessionFactory
    	ListeCourseDAO listeCourseDAO = new ListeCourseDAO();
    	ArrayList<ListeCourse> listeCourses =  (ArrayList<ListeCourse>) listeCourseDAO.findAllListeCourses();
    	
    
        request.setAttribute("listeCourses", listeCourses);
        // 转发请求到listeCourse.jsp页面
        request.getRequestDispatcher("webfronts/ListeCourse.jsp").forward(request, response);

    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/xml"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		ListeCourseDAO listeCourseDAO = new ListeCourseDAO();
		String nom = request.getParameter("Nom");
		String pt = request.getParameter("pt");
		ListeCourse lc = new ListeCourse();
		lc.setNomListe(nom);
		lc.setProduits(null);
		//listeCourseDAO.insert(lc);
		String data = "reussi";

		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    out.println("<response>");
	    out.println("<status>" + data + "</status>");
	    out.println("</response>");

	    out.close();
		
        
        
	
	}

}
