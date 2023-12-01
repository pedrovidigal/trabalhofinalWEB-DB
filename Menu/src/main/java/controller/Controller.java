package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans prato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			Pratos(request, response);
		} else if (action.equals("/insert")) {
			novoPrato(request, response);
		} else if (action.equals("/select")) {
			listarPrato(request, response);
		} else if (action.equals("/update")) {
			editarPrato(request, response);
		} else if (action.equals("/delete")) {
			removerPrato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar prato
	protected void Pratos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto q ira receber os dados JB
		ArrayList<JavaBeans> lista = dao.listarPratos();
		// encaminhar a lista
		request.setAttribute("pratos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}

	// novo prato
	protected void novoPrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		int codigo = Integer.parseInt(request.getParameter("Codigo"));
		prato.setCodigo(codigo);
		prato.setNome(request.getParameter("Nome"));
		prato.setIngredientes(request.getParameter("Ingredientes"));
		prato.setTipo(request.getParameter("Tipo"));
		// invocar o metodo inserirPrato passando objeto prato
		dao.inserirPrato(prato);
		// redirecionar para documento
		response.sendRedirect("main");
	}

	// editar prato
	protected void listarPrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String codigoStr = request.getParameter("Codigo");
			int codigo = Integer.parseInt(codigoStr);
			// Setando a variável JB (assumindo que prato é uma instância de JavaBeans)
			prato.setCodigo(codigo);
			// executar o metodo selecionarPrato DAO
			dao.selecionarPrato(prato);
			// setar o conteudo do frm
			request.setAttribute("Codigo", prato.getCodigo());
			request.setAttribute("Nome", prato.getNome());
			request.setAttribute("Ingredientes", prato.getIngredientes());
			request.setAttribute("Tipo", prato.getTipo());
			// encaminhar ao doc editar.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

	}

	protected void editarPrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JB
		int codigo = Integer.parseInt(request.getParameter("Codigo"));
		prato.setCodigo(codigo);
		prato.setNome(request.getParameter("Nome"));
		prato.setIngredientes(request.getParameter("Ingredientes"));
		prato.setTipo(request.getParameter("Tipo"));
		// executar metodo alterarPrato
		dao.alterarPrato(prato);
		// redirecionar para menu.jsp
		response.sendRedirect("main");
	}

	// remover prato
	protected void removerPrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("Codigo"));
		prato.setCodigo(codigo);
		dao.deletarPrato(prato);
		// redirecionar para menu.jsp
		response.sendRedirect("main");
	}

}
