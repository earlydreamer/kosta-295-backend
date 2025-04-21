package kosta.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import kosta.dto.MemberDTO;

public interface MemberDAO {
  /**
   * 전체검색
   * select id,pwd,name, age, phone, addr, join_date 
      from member order by join_date desc
 * @throws NamingException 
 * @throws SQLException 
   *  
   * */
	List<MemberDTO> selectAll() throws SQLException, NamingException;
	
  /**
   * 회원가입 = 등록
   * insert into member(id,pwd,name,age,phone,addr, join_date)
     values(?,?,?,?,?,?, now())
   * */
	int insert(MemberDTO memberDTO);
	
  /**
   * 상세보기 (id에 해당하는 회원정보 검색)
   * select id,pwd,name, age, phone, addr, join_date 
      from member where id=?
   * */
	MemberDTO getSelectById(String id);
	
	
  /**
   *  id에 해당하는 회원 삭제하기
   *  delete from member where id=?
   * */	
   int delete(String id);
   
	
   /**
    * id에 해당하는 정보 수정하기(비번, 나이, 주소, 연락처 )
    * update member set pwd=? , age=? , addr=? ,phone=?
    * where id=?
    * */
   int update(MemberDTO memberDTO);
	
   /**
	* 조건검색 ( keyField, keyWord에 해당하는 조건검색)
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE id LIKE ?
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE name LIKE ?
	*  SELECT id,pwd,name, age, phone, addr, join_date  FROM MEMBER  WHERE addr LIKE ?
	* */
   // keyField를 그냥 바인딩하면 ? 자리를 대체하는데 quotation이 붙음
   // where 'id' like '%' <- 이러면 정상 동작 안 함 (그냥 전체가 나옴) 
    List<MemberDTO> findBykeyFieldWord(String keyField, String keyWord);
	
}





