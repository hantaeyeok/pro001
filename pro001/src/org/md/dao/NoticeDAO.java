package org.md.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.md.dto.Notice;

public class NoticeDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<Notice> getLatestNoticeList(){
		List<Notice> notiList = new ArrayList<>();
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(OracleDB.LATEST_NOTICE);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice noti = new Notice(rs.getInt("no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("resdate"),
						rs.getInt("visited"));
				notiList.add(noti);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return notiList;
	}
	
	public List<Notice> getNoticeList(){
		List<Notice> notiList = new ArrayList<>();
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(SqlLang.SELECT_ALL_NOTICE);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice noti = new Notice(rs.getInt("no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("resdate"),
						rs.getInt("visited"));
				notiList.add(noti);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return notiList;
	}
	
<<<<<<< HEAD
	public Notice getNotice(int no) {
=======
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
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
		Notice noti = new Notice();
		OracleDB oracle = new OracleDB();
		
		try {
			con = oracle.connect();
<<<<<<< HEAD
			pstmt = con.prepareStatement(SqlLang.VISITED_UPD_NOTICE);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt = null;
			pstmt = con.prepareStatement(SqlLang.SELECT_NOTICE_BYNO);
			pstmt.setInt(1, no);
=======
			pstmt = con.prepareStatement(oracle.SELECT_NOTICE_BYNO);
			pstmt.setInt(1, no);	//첫번째 매개변수 ? 에 공지사항 no 설정
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noti.setNo(rs.getInt("no"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setResdate(rs.getString("resdate"));
				noti.setVisited(rs.getInt("visited"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return noti;
	}
	
	public int insNotice(Notice noti) {
		int cnt = 0;
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(OracleDB.INS_NOTICE);
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
	
<<<<<<< HEAD
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
		} finally {
			oracle.close(con, pstmt);
		}
		return cnt;
	}
	
	public int delNotice(int no){
=======
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
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
		int cnt = 0;
		OracleDB oracle = new OracleDB();
		try {
			con = oracle.connect();
			pstmt = con.prepareStatement(SqlLang.DEL_NOTICE);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
<<<<<<< HEAD
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
=======
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
			oracle.close(con, pstmt);
		}
		return cnt;
	}
<<<<<<< HEAD

	public Notice getNotice2(int no) {
		Notice noti = new Notice();
		OracleDB oracle = new OracleDB();
		
		try {
			con = oracle.connect();
			pstmt = null;
			pstmt = con.prepareStatement(SqlLang.SELECT_NOTICE_BYNO);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noti.setNo(rs.getInt("no"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setResdate(rs.getString("resdate"));
				noti.setVisited(rs.getInt("visited"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			oracle.close(con, pstmt, rs);
		}
		return noti;
	}
=======
	
	
	
	
	
	
	
	
	
	
	
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
}
