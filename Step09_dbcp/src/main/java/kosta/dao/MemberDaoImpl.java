package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kosta.dto.MemberDTO;
import kosta.util.DbUtil;

public class MemberDaoImpl implements MemberDAO {

	@Override
	/**
	 * 전체검색 select id,pwd,name, age, phone, addr, join_date from member order by
	 * join_date desc
	 * 
	 * @throws NamingException
	 */
	public List<MemberDTO> selectAll() throws SQLException, NamingException {

//		Context initContext = new InitialContext();
//		Context envContext = (Context)initContext.lookup("java:comp/env");
//		DataSource ds = (DataSource)envContext.lookup("jdbc/web_basic");
		Connection con = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO member = null;
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from member order by join_date"); //order by 가입일자로 정렬해줘야 함 -> pk역할을 할 컬럼이 없기 때문에 
			rs = ps.executeQuery();
			while (rs.next()) {
				member = new MemberDTO(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"),
						rs.getString("phone"), rs.getString("addr"), rs.getString("join_date"));
				memberList.add(member);
			}

		} catch (Exception e) {

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return memberList;
	}

	@Override
	public int insert(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement ps = null;

		//ResultSet rs = null;
		
		MemberDTO member = memberDTO;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"insert into member(id,pwd,name,age,phone,addr,join_date) values(?,?,?,?,?,?, now())");
 
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public MemberDTO getSelectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ps = null;

		//ResultSet rs = null;
		
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"delete from member where id=?");
			ps.setString(1, id);
			result = ps.executeUpdate();
			System.out.println("ddd");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		System.out.println(result);
		return result;		
	}

	@Override
	public int update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> findBykeyFieldWord(String keyField, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
