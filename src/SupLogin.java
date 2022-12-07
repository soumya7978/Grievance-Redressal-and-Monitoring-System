
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupLogin extends HttpServlet{
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 res.setContentType("text/html");
//		 res.setContentType("image/jpeg");
		 PrintWriter pw = res.getWriter();
		 Connection con;
		 Statement st;
		 

		
		    try
		  {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			st = con.createStatement();
			
			String id = req.getParameter("id");
			String password = req.getParameter("pwd");
			
			System.out.println("id - "+id+" pass - "+password);
			
			ResultSet rs = st.executeQuery("select * from pstaff where id ='"+ id +"' and password ='" +password +"' and dept ='SUPERINTENDENT'");
			
			if(!rs.next())
			  {
//				   pw.println("Login unsuccessful");
//				   System.out.println("un successful");
				
//				pw.println("<html><head></head><body onload = \"alert('CREDENTIALS MISMATCH')\"></body></html>");
				
				   RequestDispatcher rd=req.getRequestDispatcher("error.html");
			       rd.include(req,res);
			  }
			
			    else
			   {
			    	rs = st.executeQuery("select * from pstaff where id ='"+ id +"' and password ='" +password +"' and dept ='SUPERINTENDENT'");
			    	while(rs.next())
				 { 
			       String idc = rs.getString(1);
			       String deptc = rs.getString(2);
			       String pwdc = rs.getString(5);
				   
			
	  		       if((id.equals(idc))&&(password.equals(pwdc)))
			        {
	  		    	   System.out.println("success..");
	  		    	   
	  		    	  	  		    	 
			        	//RequestDispatcher rd =req.getRequestDispatcher("/FrontEnd/IssueRaise.html");
//			        	RequestDispatcher rd=req.getRequestDispatcher("c1.html");
//						rd.include(req,res);
						
						//issue table start
						
						rs = st.executeQuery("select * from pissue");
						
						pw.println("<html>");
						pw.println("<head>");
						pw.println("<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}.topnav {overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center;padding: 14px 16px;text-decoration: none;font-size: 17px;}.topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #04AA6D;color: white;}");
						pw.println("</style>") ;
						pw.println("<link rel=\"stylesheet\" href=\"style.css\" />");
					    pw.println("<title>HP</title>");
						pw.println("</head>");
						pw.println("<body>");
						
						//image and logo start
						
						pw.println("<div class=\"before-nav\">");
					      pw.println("<img id=\"university-logo-top\" src=\"images/imgbin_utkal-university.png\" alt=\"UU\" />");
					      pw.println("<div class=\"unv-name\">");
					        pw.println("<h2>fakir mohan chhatrabas</h2>");
					        pw.println("<h3>gent's hostel - 03</h3> <p>\r\n" + 
					        		"					          utkal university, vani vihar, <br />\r\n" + 
					        		"					          bhubaneswar, pin-751004\r\n" + 
					        		"					        </p>\r\n" + 
					        		"					      </div>\r\n" + 
					        		"					    </div>");
					        
						
						//image and logo end
						
						
						pw.println("<div class=\"topnav\"><a class=\"active\" href=\"index.html\">Home"
								+ "</a><a href=\"index.html#about\">About</a><a href=\"index.html#contact\">Contact</a>"
								+ "<a href=\"Sup_login.html\">LOGOUT</a></div><div style=\"padding-left:16px\">");
						
						pw.println("</div><br><br>");

//						    pw.println("</body>");
						    
							pw.println("<center><table border='5' width=40% height=10%\"><tr><th>RAISED ON</th><th>DEPT</th><th>ROOM NO.</th><th>STATUS</th><th>DETAILS</th><th>CONTACT</th><th>ISSUE ID</th></tr>");

						
						while(rs.next())
						 {
							
							pw.println("<tr><td>");
							pw.println(rs.getTimestamp(1));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getString(2));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getInt(3));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getString(4));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getString(5));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getString(6));
							pw.println("</td>");
							pw.println("<td>");
							pw.println(rs.getString(7));
							pw.println("</td>");
							pw.println("</tr>");
						 }
						pw.println("</table><br><br>");
						
						pw.println("<form action='SupLogin2' method='get'>");
						pw.println("<br>");
						pw.println("<select name='department' >");
						pw.println("<option>--SELECT DEPARTMENT--</option>");
						pw.println("<option value='ADMIN'>ADMIN</option>");
						pw.println("<option value='CARPENTER'>CARPENTER</option>");
						pw.println("<option value='ELECTRICIAN'>ELECTRICIAN</option>");
						pw.println("<option value='JANITOR'>JANITOR</option>");
						pw.println("<option value='MASON'>MASON</option>");
						pw.println("<option value='PAINTER'>PAINTER</option>");
						pw.println("<option value='PLUMBER'>PLUMBER</option>");
						pw.println("<option value='SECURITY'>SECURITY</option>");
						pw.println("<option value='WARDBOY'>WARDBOY</option>");

			            pw.println("</select>");
			            
			            pw.println("<input type='submit' value='SORT BY'>");
						pw.println("</form><br><br>");

						
						pw.println("<form action='Sup_login.html' method='get'>");
						pw.println("<input type='submit' value='BACK' >");
						pw.println("</form>");
						
						pw.println("<form action='Sup_login.html' method='get'>");
						pw.println("<input type='submit' value='LOGOUT' >");
						pw.println("</form>");
						
						pw.println("<form action='index.html' method='get'>");
						pw.println("<input type='submit' value='HOME' >");
						pw.println("</form");
						
						pw.println("</center></body></html>");
						
						//issue table end
					}
				 }
			   }	 
		}
		 
		 catch (Exception e)
		    {
			 System.out.println("error in SupLogin");
			 e.printStackTrace();
		    }
	  }

}