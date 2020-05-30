package com.orclLogin.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.orclLogin.dao.UserInfoDAO;

public class ConfirmAction extends ActionSupport implements SessionAware {
	private String userName;
	private String userId;
	private String password;
	private Map<String, Object> session;
	private String errorIdMessage;
	private String res = null;

	public String execute() {
		UserInfoDAO dao = new UserInfoDAO();
		String result = SUCCESS;

		if(!(userName.equals(""))
					&& !(userId.equals(""))
					&& !(password.equals(""))) {
			res = dao.checkId(userId);
			if(res != null) {
				setErrorIdMessage("すでに登録されているIDです。");
				result = ERROR;
			} else {
				session.put("userName", userName);
				session.put("userId", userId);
				session.put("password", password);
			}
		}
		return result;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getErrorIdMessage() {
		return errorIdMessage;
	}
	public void setErrorIdMessage(String errorIdMessage) {
		this.errorIdMessage = errorIdMessage;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}