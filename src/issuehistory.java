
	import java.io.*;  
	import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.*;  
	import javax.servlet.http.*;

import java.util.*;
import java.util.Date;
	
	  
	public class issuehistory extends HttpServlet
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
			   String roll ;
			   
			   //String ih = request.getParameter("ih");
			   
			   //ISSUE HISTORY

//              if(ih != null)
//			   {
//				    rs = st.executeQuery("select * from pissue");
//			pw.println("<html><body><table border='5'><tr><td>RAISED ON</td><td>DEPT</td><td>ROOM NO.</td><td>STATUS</td><td>DETAILS</td><td>CONTACT</td><td>ISSUE ID</td></tr>");
//			while(rs.next())
//			 {
//				
//				pw.println("<tr><td>");
////				Calendar cal = null;
////				Date date = new Date();
////				date = rs.getString(1);
////				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS000 a");
////				String dateStr = dateFormat.format(date);
//				pw.println(rs.getTimestamp(1));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getString(2));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getInt(3));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getString(4));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getString(5));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getString(6));
//				pw.println("</td>");
//				pw.println("<td>");
//				pw.println(rs.getString(7));
//				pw.println("</td>");
//				pw.println("</tr>");
//			 }
//			pw.println("</table></body></html>");
			
			pw.println("<html><head>");
			pw.println("<style type='text/css'>body{background: DarkSeaGreen;}.ab{color: red;font-size: 40px;font-family: Script MT Bold;}.ab1{color: white;}.ab2 input[type='submit']{background:transparent;border:none;color:#FF00FF;background:yellow;padding:5px 10px;font-size:15px;cursor:pointer;border-radius:5px;}.ab2 input[type='reset']{background:transparent;border:none;color:#FF00FF;background:yellow;padding:5px 10px;font-size:15px;cursor:pointer;border-radius:5px;}</style>");
			pw.println("</head>");
		
			pw.println("<body><center><form action='issuehistory2' method='get'>");

			pw.println("<h2 class='ab'>Enter Room Number</h2><br>");
			pw.println("<div class='inputBox'>");

			pw.println("<input type=text name='id' size=3>: ROOM NUMBER");

			pw.println("</div><br><br>");		
			pw.println("<input type='submit' name='submit' value='Submit'>");
			pw.println("<input type='reset' value='Reset' >");
			pw.println("</form>");	
			
			pw.println("<br><br>");
			
			pw.println("<form action='index.html' method='get'>");
			pw.println("<input type='submit' value='HOME' >");
			pw.println("</form>");
			
			pw.println("<form action='Student_login.html' method='get'>");
			pw.println("<input type='submit' value='LOGOUT' >");
			pw.println("</form>");
			
			pw.println("</center></body>");
			pw.println("</html>");


//		 }
			   
			 
			   //rs.close(); 
			   
	    }  
	  
			catch (Exception e)
			{
				e.printStackTrace();
				pw.println("ERROR IN EXCEPTION");
			} 

	}
	  
	}  
