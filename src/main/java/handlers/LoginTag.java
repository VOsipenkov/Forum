package handlers;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class LoginTag extends SimpleTagSupport {
    private String method;
    private String url;

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder result = new StringBuilder();
        result.append("<form method=\"" + method + "\" action=\"" + url + "\">");

        result.append("<p>Login</p><input type=\"text\" name=\"Login\">");
        result.append("<p>Password</p><input type=\"password\" name=\"Password\">");
        result.append("<br><br>");
        result.append("<input type=\"submit\" value=\"Log in\"/>");

        result.append("</form>");
        result.append("<br>");

        getJspContext().getOut().print(result.toString());
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }


//
//     <div class="outer">
//	<form method = "POST" action = "/loginController">
//		<p>Login</p><input type = "text" name = "Login">
//		<p>Password</p><input type = "password" name = "Password">
//		<br>
//		<br>
//		<input type = "submit" value = "Log in">
//    </form>
//</div>
}
