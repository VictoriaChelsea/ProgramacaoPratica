package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Pais;
import service.PaisService;

public class CriarPais implements Command {
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  
	    String pId = request.getParameter("id");
	    String pNome = request.getParameter("nome");
	    long pPopulacao = Long.parseLong(request.getParameter("populacao")); 
	    float pArea = Float.parseFloat(request.getParameter("area"));
	    
	    int id = -1;
	    
	    try{
	    	id = Integer.parseInt(pId);
	    }catch (NumberFormatException e) {
			
		}
	    
	    
	    //instanciar o javabean
	    Pais pais = new Pais();
	    pais.setId(id);
	    pais.setNome(pNome);
	    pais.setPopulacao((long) pPopulacao);
	    pais.setArea(pArea);
	    PaisService cs = new PaisService();    //instanciar o service
	    
	    RequestDispatcher view =null;
	    HttpSession session = request.getSession();
	    
	    cs.criar(pais);
	    ArrayList<Pais> lista = new ArrayList<>();
	    lista.add(pais);
	    session.setAttribute("lista", lista);
	    view = request.getRequestDispatcher("ListarPais.jsp");

		view.forward(request, response);
	
	    

	}
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}
}
