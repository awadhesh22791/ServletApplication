package demo.constant;

public interface View {
	public String viewBase="/WEB-INF/views/%s.jsp";
	public String loginPage=String.format(viewBase, "login");
	public String homePage=String.format(viewBase, "home");
}
