import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.UUID;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentIssueRaise")
public class StudentIssueRaise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String P = null;
	
	public String status="P";
	//public int roomno=0;
	public  Timestamp id=new Timestamp(System.currentTimeMillis());
	
	String iid = UUID.randomUUID().toString(); 
	
	
//	public Timestamp id1 = new Timestamp(System.)
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		

		String roll = request.getParameter("roll");
		int roomno = Integer.parseInt(request.getParameter("roomno"));
		String department=request.getParameter("department");
		String mobile=request.getParameter("mobile");
		String details=request.getParameter("details");
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			
			Statement st=con.createStatement();
			
			//new timestamp
//			Date date = new Date();
//			DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
//			String outputString = outputFormat.format(date);
			
			//print timestamp id
			System.out.println(id) ;
			
			ResultSet rs=st.executeQuery("select ROLLNO from pstudent where ROOMNO='"+roomno+"'");
			//int i=0;
			while(rs.next()) {
				String rlc=rs.getString(1);
				
				
				
				if( roll.equals(rlc) ) {
					
					
				        PreparedStatement ps=con.prepareStatement("insert into pissue values(?,?,?,?,?,?,?)");
						ps.setTimestamp(1, id);
						ps.setString(2, department);
						ps.setInt(3, roomno);
						ps.setString(4, status);
						ps.setString(5, details);
						ps.setString(6, mobile);
						ps.setString(7, iid);
						
						int i=ps.executeUpdate();
						
                       if(i>0) {
						System.out.println("Issue raised successfully") ;
						//out.println("<html><head></head><body onload=\"alert('ISSUE RAISED SUCCESSFULLY')\"></body></html>");
						
						RequestDispatcher rd=request.getRequestDispatcher("ActionComplete.html");
						rd.include(request,response);
						

						
                       }
						
//						
						
//						if(i>0) {
//							
//							RequestDispatcher rd=request.getRequestDispatcher("sir2");
//							rd.include(request, response);
//				
				            }
//				
				}
				
				
				
           
				
				
			
			
//			 if(i==0){
//					
//					out.println("<html><head></head><body onload=\"alert('Roll No and Room No MisMatch')\"></body></html>");
//					//out.print(" Roll No and Room No Missmatch");
//					RequestDispatcher rd=request.getRequestDispatcher("IssueRaise.html");
//					rd.include(request, response);
//	           
//					}

			
			
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("ERROR OCCURED");
		}
		
		
	}

}
