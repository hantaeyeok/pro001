package org.md.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dto.Notice;


@WebServlet("/EditProNotice.do")
public class EditProNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditProNoticeCtrl() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// editproNotice 만들어서 리스트에 추가해야함. noticeDAO
		NoticeDAO dao = new NoticeDAO();
		//폼에서 받은 입력값을 넣어줘야함
		Notice noti = new Notice();
		noti.setNo(Integer.parseInt(request.getParameter("no")));
		noti.setTitle(request.getParameter("title"));
		noti.setTitle(request.getParameter("content"));
		
		int cnt = dao.editProNotice(noti);
		
		if(cnt>0) {//cnt 1이상이면 목록으로 수정완료
			response.sendRedirect("/pro001/NotiList.do");
		} else { // 0이면 수정 실패 다시 글 수정으로 가야함.
			response.sendRedirect("/pro001/EditNotice.do?no="+noti.getNo());
		}
		//여기까지햇으면 getNotice.jsp 로이동하여 -> del 
	}

}
