package controller;

import com.google.gson.Gson;
import dao.ModuleDAO;
import model.ModuleFormation;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ModuleServlet extends HttpServlet {
    private ModuleDAO moduleDAO = new ModuleDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ModuleFormation> modules = moduleDAO.listerTous();
        String json = new Gson().toJson(modules);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
