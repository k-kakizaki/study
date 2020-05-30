package com.orclLogin.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.orclLogin.dao.UserInfoDAO;
import com.orclLogin.dto.UserInfoDTO;

public class LoginAction extends ActionSupport implements SessionAware {
	private String userId;
	private String password;
	private Map<String,Object> session;
	private String errorMessage;

	public String execute() {
		String result = ERROR;
		UserInfoDAO dao = new UserInfoDAO();
		UserInfoDTO dto = new UserInfoDTO();

		dto = dao.select(userId, password);

		if(userId.equals(dto.getUserId())){
			if(password.equals(dto.getPassword())){
				result = SUCCESS;
				String userName = dto.getUserName();
				session.put("userName", userName);
				session.put("userId", userId);
				session.put("password", password);
			} else {
				setErrorMessage("ユーザーIDまたはパスワードが異なります。");
			}
		} else {
			setErrorMessage("ユーザーIDまたはパスワードが異なります。");
		}
		return result;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}