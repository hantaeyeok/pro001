package org.md.ctrl.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dto.Notice;

@WebServlet("/GetNotice.do")
public class GetNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetNoticeCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//utf-8 설정
		
		//특정 공지사항 번호에 해당하는 공지사항 정보를 가져오는 메서드 만들기
		
		
//		NoticeDAO dao = new NoticeDAO();
		
		// int no = request.getParameter("no"); parameter는 String으로 받아 int로 변환해야함, 
		// getparmeter와 getAttribute 차이
		// getparameter는 notice noti에서 no인것을 찾아 그 값을 읽어옴
		//get attribute는 setattribute("no", "1")이라고 지정해야함
		// 잘모르겠는데 사용자 창에서 from같이 클릭해서 번호를 들어가서 파라미터인거 같음 다시 찾아야함
		//form을 통해 공지사항 번호를 서블릿에 전달해야하기때문에,
		
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDAO dao = new NoticeDAO();
		Notice noti = dao.getNotice(no);
		
		request.setAttribute("noti", noti); //공지사항 정보를 jsp 전달하기 위해 
		RequestDispatcher view = request.getRequestDispatcher("/notice/getNotice.jsp");	//공지사항 상세보기 jsp로 이동
		view.forward(request, response);	//정보보내주기
		
		
	}

}
