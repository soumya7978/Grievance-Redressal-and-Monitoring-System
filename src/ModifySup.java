
import java.sql.*;
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
import javax.servlet.http.HttpSession;


@WebServlet("/ModifySup")
public class ModifySup extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		//id=request.setAttribute("id", id);
		out.println("<html><body>");
		
		HttpSession session = request.getSession();
		session.setAttribute("updateId", id);
		System.out.println("session - "+session.toString());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("select *from pstaff where id =? and dept ='SUPERINTENDENT'");
			
			
			ps.setString(1,id);
			//int i=ps.executeUpdate();
			
			ResultSet rs=ps.executeQuery();
			
//header
		    
		    out.println("<html>");
			out.println("<head>");
			out.println("<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}.topnav {overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center;padding: 14px 16px;text-decoration: none;font-size: 17px;}.topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #04AA6D;color: white;}");
			out.println("</style>") ;
			out.println("<link rel=\"stylesheet\" href=\"style.css\" />");
		    out.println("<title>HP</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<div class=\"before-nav\">");
		      out.println("<img id=\"university-logo-top\" src=\"images/imgbin_utkal-university.png\" alt=\"UU\" />");
		      out.println("<div class=\"unv-name\">");
		        out.println("<h2>fakir mohan chhatrabas</h2>");
		        out.println("<h3>gent's hostel - 03</h3> <p>\r\n" + 
		        		"					          utkal university, vani vihar, <br />\r\n" + 
		        		"					          bhubaneswar, pin-751004\r\n" + 
		        		"					        </p>\r\n" + 
		        		"					      </div>\r\n" + 
		        		"					    </div>");
		        
			
			out.println("<div class=\"topnav\"><a class=\"active\" href=\"index.html\">Home"
					+ "</a><a href=\"index.html#about\">About</a><a href=\"index.html#contact\">Contact</a>"
					+ "<a href=\"Sup_login.html\">LOGOUT</a></div><div style=\"padding-left:16px\">");
			
			out.println("</div><br><br>");
		    
		    //header end
			
			out.println(" <center><table border=2 width=50% height=20%");
			out.println("<tr><th>ID</th><th>DEPT</th><th>NAME</th><th>CONTACT</th><th>PASSWORD</th>");
			
			while(rs.next()) {
				//out.print(rs.getString(2));
				String idc=rs.getString(1);
				String dept=rs.getString(2);
				String name=rs.getString(3);
				String contact=rs.getString(4);
				String password=rs.getString(5);
				
				
				//out.println("<tr><td>"+idc+"</tr></td>" +dept+"<tr><td>"+name+"</tr></td>" +contact+"<tr><td>"+password+"</tr></td>");
				out.println("<tr><td>"+idc+"</td><td>"+dept+"</td><td>"+name+"</td><td>"+contact+"</td><td>"+password+"</td></tr>");
				
			}
			out.println("</center></table>");
			
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			
			out.println("<form action='ModifySup2' method='get'>");
			//out.println("<input type='text' name='id' placeholder='ID' <br>");
			out.println("<br>");
			out.println("<select name='department' >");
			out.println("<option value='SUPERINTENDENT'>SUPERINTENDENT</option>");
			
          out.println("</select>");
			
			
			out.println("<br>");
			
			out.println("<input type='text' name='name' placeholder='FULL NAME' <br>  ");
			out.println("<br>");
			out.println("<input type='text' name='mobile' placeholder='MOBILE NUMBER' <br> ");
			out.println("<br>");
			out.println("<input type='text' name='password' placeholder='PASSWORD' <br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			

			
			out.println("<input type='submit' value='UPDATE' />");
 
//			out.println("</table>");
			out.println("</form");
			out.println("</body></html>");
			
			
			
		}
		catch(Exception e) {
			System.out.println("error in ModifySup");
			
		}
		
	}

}
