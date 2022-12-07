
	import java.io.*;  
	import java.sql.*;
	import javax.servlet.*;  
	import javax.servlet.http.*;
	  
	public class solveissue extends HttpServlet
	{
	    public void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException 
			{  
			 response.setContentType("text/html");  
	         PrintWriter pw = response.getWriter();  
	         Connection con;
	         Statement st;
			 
			 try
			 {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			   st = con.createStatement(); 
			   ResultSet rs = null;
			   
				String id = request.getParameter("id");
				
				System.out.println(id);

				//pw.println("<h2>ISSUE HISTORY OF ROOM NUMBER : " + id + "</h2>");
				
				rs = st.executeQuery("update pissue set status ='S' where IID= '"+id+"'");
			   
			   			   rs.close(); 
			   			   
			   			RequestDispatcher rd=request.getRequestDispatcher("ActionComplete.html");
						rd.include(request,response);
			   
	    }  
	  
			catch (Exception e)
			{
				e.printStackTrace();
			} 

	}
	  
	}  
