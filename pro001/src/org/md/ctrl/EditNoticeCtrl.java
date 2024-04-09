package org.md.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dto.Notice;


@WebServlet("/EditNotice.do")
public class EditNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditNoticeCtrl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//글수정
		
		//NoticeDAO 수정 하는 메서드 만들기
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDAO dao = new NoticeDAO();
		Notice noti = dao.getNotice2(no);
		
		request.setAttribute("noti", noti);
		RequestDispatcher view = request.getRequestDispatcher("/notice/editNotice.jsp");
		view.forward(request, response);
		
	}

}
