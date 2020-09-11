package com.mimaraslan;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * A CDI managed bean.
 */
/*
 * Endpoint for Frontend
 * 
 * http://localhost:8080/my-001-jakartaee-frontend/
 */
@Named
@SessionScoped
public class AppMain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personInfo;

	private String personResult;

	public String getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(String personInfo) {
		this.personInfo = personInfo;
	}

	public String getPersonResult() {
		return personResult;
	}

	public void setPersonResult(String personResult) {
		this.personResult = personResult;
	}

	public String person() {

		try {
			Client client = ClientBuilder.newClient();
			String url = "http://localhost:8080/my-001-jakartaee-backend/webapi/person/" + getPersonInfo();
			WebTarget target = client.target(url);
			personResult = target.request().get(String.class);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("myform:getdate", new FacesMessage("Exception " + e, "Exception " + e));
			personResult = "lolo";
			return null;
		}

		return "/response.xhtml";
	}
}