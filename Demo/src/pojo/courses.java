package pojo;

import java.util.List;

public class courses {

	private	List<webautomation> webAutomation;
	public List<webautomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webautomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<api> getApi() {
		return api;
	}
	public void setApi(List<pojo.api> api) {
		this.api = api;
	}
	public List<pojo.mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<pojo.mobile> mobile) {
		this.mobile = mobile;
	}
	private List<pojo.api> api;
	private List<mobile> mobile;
		

}
