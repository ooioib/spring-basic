package org.codenova.spring.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;
import java.util.Map;

public class IndexView implements View {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<h2>" + model.get("msg") + "</h2>");
    }
}
