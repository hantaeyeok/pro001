package org.md.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.md.dto.Notice;

public class NoticeDAO {
	//NoticeDAO는 DB에 있는 Notice를  목록으로 불러 저장하기 위해 DB연결을 해야함
	//그전에 OracleDB 연결을 해야함
	//db 연결 list 호출
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1번 select sql select * from notice order by resdate desc
	public List<Notice> getNoticeList(){
		List<Notice> notiList = new ArrayList<>();
		OracleDB oracle = new OracleDB();
		
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(oracle.SELECT_ALL_NOTICE);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice noti = new Notice(
						rs.getInt("no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("resdate"),
						rs.getInt("visited"));
				notiList.add(noti);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			oracle.close(con, pstmt, rs);
		}
		return notiList;
	}
	
	//2번 select * from notice where no=?
	//메서드는 특정 공지사항 번호를 입력받아 그에 해당하는 공지사항 정보를 반환
//	public Notice getNotice(int no) {	//getNotice(번호)로 그 번호의 테이터를 호출
//		Notice noti = new Notice();
//		OracleDB oracle = new OracleDB();
//		
//		try {
//			pstmt = con.prepareStatement(oracle.SELECT_NOTICE_BYNO);	//
//			pstmt.setInt(1, no);	//첫번째 매개변수 ? 에 공지사항 no 설정
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				noti.setNo(rs.getInt("no"));
//				noti.setTitle(rs.getString("title"));
//				noti.setContent(rs.getString("content"));
//				noti.setResdate(rs.getString("resdate"));
//				noti.setVisited(rs.getInt("visited"));
//			}
//		} catch(Exception e){
//			e.printStackTrace();
//		} finally {
//			oracle.close(con, pstmt, rs);
//		}
//		return noti;
//	}
	//방문자 추가하기
	
	public void updateVisited(int no) {
		Notice noti = new Notice();
	    OracleDB oracle = new OracleDB();
	    try {
	        con = oracle.connect();
	        pstmt = con.prepareStatement(SqlLang.VISITED_UPD_NOTICE);
	        pstmt.setInt(1, no);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        oracle.close(con, pstmt);
	    }
	   
	}
		
		
	
	public Notice getNotice(int no) {	//getNotice(번호)로 그 번호의 테이터를 호출
		Notice noti = new Notice();
		OracleDB oracle = new OracleDB();
		
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(oracle.SELECT_NOTICE_BYNO);
			pstmt.setInt(1, no);	//첫번째 매개변수 ? 에 공지사항 no 설정
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noti.setNo(rs.getInt("no"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setResdate(rs.getString("resdate"));
				noti.setVisited(rs.getInt("visited"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return noti;
	}
	
	//3번 insert into notice values (nseq.nextval, ?, ?, sysdate, 0)
	// 데이터베이스에 공지사항을 삽입한 후에 성곡적으로 이루어졌는지 int로 알려주기 위함 성공시 1 반환 실팻히 0 반환
	public int insNotice(Notice noti) {
		int cnt =0 ;
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(oracle.INS_NOTICE);
			//sql 문 ? ? 순서를 사용하기 위해 setString 사용
			pstmt.setString(1, noti.getTitle());
			pstmt.setString(2, noti.getContent());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt);
		}
		return cnt;
	}
	
	//글 수정은 수정한 내용을 받아서 그 내용을 editpro로 변환 이 부분은 추가랑 같음.
	public Notice getNotice2(int no) {	//getNotice(번호)로 그 번호의 테이터를 호출
		Notice noti = new Notice();
		OracleDB oracle = new OracleDB();
		
		try {
			pstmt = con.prepareStatement(oracle.SELECT_NOTICE_BYNO);	//
			pstmt.setInt(1, no);	//첫번째 매개변수 ? 에 공지사항 no 설정
			rs = pstmt.executeQuery();
			if(rs.next()) {
			noti.setNo(rs.getInt("no"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setResdate(rs.getString("resdate"));
				noti.setVisited(rs.getInt("visited"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return noti;
	}
	
	
	public int editProNotice(Notice noti) {
		int cnt = 0;
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(SqlLang.UPD_NOTICE);
			pstmt.setString(1, noti.getTitle());
			pstmt.setString(2, noti.getContent());
			pstmt.setInt(3, noti.getNo());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			oracle.close(con, pstmt);
		}
		return cnt;
	}
	
	
	public int delNotice(int no) {
		int cnt = 0;
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(SqlLang.DEL_NOTICE);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			oracle.close(con, pstmt);
		}
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
}
