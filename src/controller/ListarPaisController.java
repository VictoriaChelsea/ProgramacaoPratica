package controller;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.VendedorService;
import service.PaisService;
import model.Pais;
import java.io.*;

@WebServlet("/listar_pais.do")
public class ListarPaisController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	 protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
		 request.setCharacterEncoding("UTF-8");
		 String chave = request.getParameter("data[search]");
		 String acao = request.getParameter("acao");
		 VendedorService vendedor = new VendedorService();
		 ArrayList<Pais> lista =null;
		 HttpSession session  = request.getSession();
		 
		
		 
		 if(acao.equals("busca")) {
			 if(chave != null && chave.length()>0) {
				 lista = vendedor.listarPais(chave);
			 }else {
				 lista = vendedor.listarPais();
			 }
			 session.setAttribute("lista", lista);
		 }else if(acao.equals("reniciar")) {
			 session.setAttribute("lista", null);
		 }
		 
		 RequestDispatcher dispatcher = request
				 .getRequestDispatcher("ListarPais.jsp");
		 dispatcher.forward(request, response);
	 }
	 
	 protected void doPost(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException{
		 doGet(request, response);
	 }
}
