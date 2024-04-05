package org.md.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dto.Notice;

@WebServlet("/NotiList.do")
public class NoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//utf-8 설정
		
		NoticeDAO dao = new NoticeDAO();//NoticeDAO : db 받은 클래스 호출하려고 만듬
		//dao를 만들어 공지사항 목록을 가져오기 위해 데이터베이스와 통신할수 잇는 dao객체 생성
		// 서블릿은 dao객체를 통해 목록을 가져와 데이터를 전송할수있는...
		//controller -> dao
		//dao-> controller
		List<Notice> notiList = new ArrayList<>();
		notiList = dao.getNoticeDAO();
		request.setAttribute("notiList", notiList);	
		//notiList를 jsp페이지에 넘겨주기위한 구문 
		//jsp 에서 getParameter()로 받아준다.
		RequestDispatcher view = request.getRequestDispatcher("/notice/noticeList.jsp");
		//jsp로 포워딩 하기 위한 구문
		view.forward(request, response);
		//
		
		
	}

}
