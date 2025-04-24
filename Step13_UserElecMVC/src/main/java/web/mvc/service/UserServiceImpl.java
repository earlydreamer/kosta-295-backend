package web.mvc.service;

import java.sql.SQLException;

import web.mvc.dto.UserDTO;
import web.mvc.dao.UserDAO;
import web.mvc.dao.UserDAOImpl;
import web.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		UserDTO user = userDTO;
		UserDAO dao = new UserDAOImpl();
		//userDTO 정보를 받아옴
		
		
		dao.loginCheck(userDTO);		
		
		
		
		//
		
		
		
		return userDTO;
	}

	//로그아웃 메서드
	                                                                                                                
	
}
