
	import java.io.*;  
	import java.sql.*;
	import javax.servlet.*;  
	import javax.servlet.http.*;
	  
	public class issuehistory2 extends HttpServlet
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
			   
               String roll = request.getParameter("roll");  
			   int id = Integer.parseInt((request.getParameter("room")));

				rs = st.executeQuery("select * from pissue where roomno ="+ id);
				
				//header
			    
			    pw.println("<html>");
				pw.println("<head>");
				pw.println("<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}.topnav {overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center;padding: 14px 16px;text-decoration: none;font-size: 17px;}.topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #04AA6D;color: white;}");
				pw.println("</style>") ;
				pw.println("<link rel=\"stylesheet\" href=\"style.css\" />");
			    pw.println("<title>HP</title>");
				pw.println("</head>");
				pw.println("<body>");
				
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
			        
				
				pw.println("<div class=\"topnav\"><a class=\"active\" href=\"index.html\">Home"
						+ "</a><a href=\"index.html#about\">About</a><a href=\"index.html#contact\">Contact</a>"
						+ "<a href=\"Student_login.html\">LOGOUT</a></div><div style=\"padding-left:16px\">");
				
				pw.println("</div><br><br>");
			    
			    //header end
				
				pw.println("<h2>ISSUE HISTORY OF ROOM NUMBER : " + id + "</h2>");

				
				pw.println("<center><table border='5' width=60% height=20%\"><tr><th>RAISED ON</th><th>DEPT</th><th>ROOM NO.</th><th>STATUS</th><th>DETAILS</th><th>CONTACT</th><th>ISSUE ID</th></tr>");
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
				pw.println("</table></center></body></html>");
				
				//SOLVE ISSUE
				
				pw.println("<html><head>");
				pw.println("<style type='text/css'>body{background: DarkSeaGreen;}.ab{color: red;font-size: 40px;font-family: Script MT Bold;}.ab1{color: white;}.ab2 input[type='submit']{background:transparent;border:none;color:#FF00FF;background:yellow;padding:5px 10px;font-size:15px;cursor:pointer;border-radius:5px;}.ab2 input[type='reset']{background:transparent;border:none;color:#FF00FF;background:yellow;padding:5px 10px;font-size:15px;cursor:pointer;border-radius:5px;}</style>");
				pw.println("</head>");
			
				pw.println("<body><form action='solveissue' method='get'>");

				pw.println("<h2 class='ab'>Enter ISSUE ID</h2>");
			
				pw.println("<div class='inputBox'>");

				pw.println("<input type=text name='id' size=40>: ISSUE ID");

				pw.println("</div>");		
				pw.println("<input type='submit' name='submit' value='SOLVE ISSUE'>");
				pw.println("<input type='reset' value='RESET' >");
		
				pw.println("</form>");	
				
				pw.println("<form action='index.html' method='get'>");
				pw.println("<input type='submit' value='HOME' >");
				pw.println("</form>");
				
				pw.println("<form action='Student_login.html' method='get'>");
				pw.println("<input type='submit' value='LOGOUT' >");
				pw.println("</form>");

				
				pw.println("</body>");
				pw.println("</html>");


			   
			   			   rs.close(); 
			   
	    }  
	  
			catch (Exception e)
			{
				e.printStackTrace();
			} 

	}
	  
	}  
