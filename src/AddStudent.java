

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con ;
		
		String roll=request.getParameter("roll");
		String name=request.getParameter("name");
		String department=request.getParameter("department");
		String period=request.getParameter("period");
		String mobile=request.getParameter("mobile");
		int roomno = Integer.parseInt(request.getParameter("roomno"));
		String password=request.getParameter("password");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("insert into pstudent values(?,?,?,?,?,?,?)");
			
			ps.setString(1, roll);
			ps.setString(2, name);
			ps.setString(3, department);
			ps.setString(4, period);
			ps.setInt(5, roomno);
			ps.setString(6, mobile);
			ps.setString(7, password);
			
			int i=ps.executeUpdate();
			if(i>0) {
				
				//out.println("<html><head></head><body onload=\"alert('Successfully Added')\"></body></html>");
//				out.println(" Successful....");
				RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
				rd.include(request, response);
			}
			else {
				out.println(" Error....");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
