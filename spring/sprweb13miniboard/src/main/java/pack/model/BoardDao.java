package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	@Autowired
	public BoardDao(DataSource dataSource) {
		try {
			ds = dataSource;
		} catch (Exception e) {
			System.out.println("연결 실패:" + e);
		}

	}

	public List<BoardDto> list() { // 전체 자료 읽기
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();

		try {
			conn = ds.getConnection();

			String sql = "select * from springboard order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNum(rs.getInt("num"));
				boardDto.setAuthor(rs.getString("author"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setBwrite(rs.getString("bwrite"));
				boardDto.setReadcnt(rs.getInt("readcnt"));
				list.add(boardDto);
			}
		} catch (Exception e) {
			System.out.println("list er : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public boolean writeData(BoardBean bean) {

		boolean b = false;

		try {
			int newnum = 1;
			String sql = "select max(num) from springboard";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				newnum = rs.getInt(1) + 1; // 새 글번호 얻기

			sql = "insert into springboard(num,author,title,content) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newnum);
			pstmt.setString(2, bean.getAuthor());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getContent());

			if (pstmt.executeUpdate() > 0)
				b = true; // 추가 성공

		} catch (Exception e) {
			System.out.println("writeDate err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return b;
	}

	public List<BoardDto> search(String name, String value) { // 검색 결과 처리
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();

		try {
			conn = ds.getConnection();

			String sql = "select * from springboard where " + name + " like '%" + value + "%'";
			sql += " order by num desc";

			System.out.println("sql : " + sql);

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNum(rs.getInt("num"));
				boardDto.setAuthor(rs.getString("author"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setBwrite(rs.getString("bwrite"));
				boardDto.setReadcnt(rs.getInt("readcnt"));
				list.add(boardDto);
			}
		} catch (Exception e) {
			System.out.println("search er : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public BoardDto detail(String num) {
		BoardDto boardDto = null;

		try {
			// 상세보기 할 때마다 조회수를 증가
			String sql = "update springboard set readcnt=readcnt+1 where num=" + num;

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

			// 상세보기 대상 레코드 읽기
			sql = "select * from springboard where num=" + num;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setNum(rs.getInt("num"));
				boardDto.setAuthor(rs.getString("author"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setBwrite(rs.getString("bwrite"));
				boardDto.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			System.out.println("detail err : "+e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return boardDto;
	}
}
