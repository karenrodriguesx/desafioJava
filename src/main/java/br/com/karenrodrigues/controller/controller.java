package br.com.karenrodrigues.controller;

import br.com.karenrodrigues.model.DAO;
import br.com.karenrodrigues.model.JavaBeans;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet (urlPatterns = {"/controller", "/insert", "/listaUsuarios", "/delete"})
public class controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DAO dao = new DAO();

    JavaBeans usuario = new JavaBeans();
    public controller() {
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getServletPath();
        System.out.print(action);
        if (action.equals("/listaUsuarios")) {
            usuarios(request, response);
        } else
        if (action.equals("/insert")) {
            novoUsuario(request, response);
        } else
            if (action.equals("/delete")) {
            excluirUsuario(request, response);
    }}

    //Listar usuarios cadatrados
    protected void usuarios (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        ArrayList<JavaBeans> listaUsuarios = dao.listaUsuarios();

        request.setAttribute("usuarios", listaUsuarios);
        RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
        rd.forward(request, response);
    }

    protected void novoUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        usuario.setNome(request.getParameter("nome"));
        usuario.setProfissao(request.getParameter("profissao"));
        usuario.setIdade(Integer.parseInt(request.getParameter("idade")));

        dao.insert(usuario);

        response.sendRedirect("listaUsuarios");
    }

        protected void excluirUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
            String id = request.getParameter("id");
            usuario.setId(id);

            dao.delete(usuario);

            response.sendRedirect("listaUsuarios");
        }

}

