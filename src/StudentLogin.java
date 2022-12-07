

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentLogin extends HttpServlet{
	
//	@Override
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
//		RequestDispatcher rd=req.getRequestDispatcher("/FrontEnd/IssueRaise.html");
//		rd.include(req,resp);
//		resp.getWriter().write("Hi , Samir Here");
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		   
		 res.setContentType("text/html");
		 PrintWriter pw = res.getWriter();
		 Connection con;
		 Statement st;
		
		    try
		  {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			st = con.createStatement();
			
			String roll = req.getParameter("roll");
			String password = req.getParameter("pwd");
			
			System.out.println("roll - "+roll+" pass - "+password);
			
			ResultSet rs = st.executeQuery("select * from pstudent where rollno ='"+ roll +"' and password ='" +password +"'");
			
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
			     rs = st.executeQuery("select * from pstudent where rollno ='"+ roll +"' and password ='" +password +"'");
			     while(rs.next())
				 { 
			       String rollc = rs.getString(1);
			       String namec = rs.getString(2);
			       String roomc = rs.getString(5);
			       String pwdc = rs.getString(7);
//				   
//				   pw.println(rollc);
//				   pw.println(namec);
//				   pw.println(roomc);
			
	  		       if((roll.equals(rollc))&&(password.equals(pwdc)))
			        {
	  		    	   System.out.println("success..");
	  		    	   
	  		    	  	  		    	 
			        	//RequestDispatcher rd=req.getRequestDispatcher("/FrontEnd/IssueRaise.html");
			        	RequestDispatcher rd=req.getRequestDispatcher("c1.html");
						rd.include(req,res);
					}
				 }
			   }	 
		}
		 
		 catch (Exception e)
		    {
			 System.out.println("error...");
			 e.printStackTrace();
		    }
	  }

}
