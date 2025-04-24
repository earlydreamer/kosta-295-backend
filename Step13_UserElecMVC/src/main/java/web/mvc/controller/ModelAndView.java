package web.mvc.controller;

/**
 * 각 요청에 대한 처리를 한 후 최종적으로 이동할 뷰 정보와 이동 방식에 관한 속성을 관리
 */
public class ModelAndView {
	private String viewName = null;// 이동할 view
	private boolean isRedirect = false; // true이면 redirect false면 forward로

	public ModelAndView() {

	}

	public ModelAndView(String viewName) {
		this.viewName=viewName;
	}

	public ModelAndView(String viewName, boolean isRedirect) {
		this.viewName=viewName;
		this.isRedirect=isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
