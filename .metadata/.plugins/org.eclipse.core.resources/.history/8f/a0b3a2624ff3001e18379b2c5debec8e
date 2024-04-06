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
	
	public List<Notice> getNoticeDAO(){
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
}
