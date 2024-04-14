package org.md.ctrl.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dto.Notice;

@WebServlet("/NotiIns.do")
public class NotiInsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NotiInsCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//utp-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//Notice클래스에 데이터 저장
		Notice noti = new Notice();
		noti.setTitle(request.getParameter("title"));
		noti.setContent(request.getParameter("content"));
		
		//NoticeDAO
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.insNotice(noti);
		
		if(cnt>0) {
			System.out.println("공지사항 추가 성공");
		} else {
			System.out.println("공지사항 추가 실패");
		}
		
		List<Notice> notiList = new ArrayList<>();
		notiList = dao.getNoticeList();
		request.setAttribute("notiList", notiList);		
		RequestDispatcher view = request.getRequestDispatcher("/notice/noticeList.jsp");
		view.forward(request, response);
		
		
		//home을 지정해서 그 경로부터 어디로 이동해야할지 지정해야하기에 경로를 지정한거 같음
		ServletContext application = request.getServletContext();
		String home = application.getContextPath();	//application의 경로 
		if(cnt>0) {
			response.sendRedirect(home+"/NotiList.do");	//성공하면 공지사항 목록 페이지로 이동
		} else {
			response.sendRedirect(home+"/notice/noti_ins.jsp");	//실패하면 공지사항 추가페이로 이동
		}
	
	}

}
