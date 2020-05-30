package com.orclLogin.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.orclLogin.dao.UserInfoDAO;

public class CompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private UserInfoDAO dao = new UserInfoDAO();

	public String execute() throws SQLException {
		dao.create(session.get("userName").toString(),
				session.get("userId").toString(),
				session.get("password").toString());

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}