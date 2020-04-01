package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Method.DaoTxt;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int correct=0;
		int fault=0;
		int i=0;
		int j=0;
		int q=0;
		int[] correctSet = new int[10000];
		int[] faultSet=new int[10000];
		String[] val=request.getParameterValues("text");
		String resu=request.getParameter("result");
		System.out.println(resu);
		String[] result=resu.split(",");
		System.out.println(result[0]);
		DaoTxt dao=new DaoTxt(); 
		for (String s : val) {
			if(s.equals(result[i])) {
				correct++;
				correctSet[j++]=i+1;
				i++;
			}else {
				fault++;
				faultSet[q++]=i+1;
				i++;
			}
		}

		System.out.println("hello");
		dao.saveGrade("correct:"+j+"---(");
		for(int w=0;w<j;w++) {
			if(w!=j-1) {
			dao.saveGrade(""+correctSet[w]+",");
		}else {
			dao.saveGrade(""+correctSet[w]+")\r\n");
		}
			
		}
		dao.saveGrade("default:"+q+"---(");
		for(int w=0;w<q;w++) {
			if(w!=q-1) {
			dao.saveGrade(""+faultSet[w]+",");
		}else {
			dao.saveGrade(""+faultSet[w]+")\r\n");
		}
			
		}
		response.sendRedirect("successful.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
