package handlers;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class FormTag extends SimpleTagSupport {
    private String method;
    private String url;

    public void setInputItems(List<String> inputItems) {
        this.inputItems = inputItems;
    }

    private List<String> inputItems;

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder result = new StringBuilder();
        result.append("<form method=\"" + method + "\" action=\"" + url + "\">");
        for (String item : inputItems) {
            result.append("<p>" + item + " ");
            result.append("<input type=\"text\" name=\"" + item + "\"></p>");
        }

        result.append("<br>");
        result.append("<input type=\"submit\" value=\"enter\"/>");

        result.append("</form><br>");

        getJspContext().getOut().print(result.toString());
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
