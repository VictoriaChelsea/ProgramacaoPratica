package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command {
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pCommand = request.getParameter("command");
	    String pId = request.getParameter("id");
	    String pNome = request.getParameter("nome");
	    long pPopulacao = 0L;
	    float pArea = 0L;
	    
	    if(pCommand != "ExcluirPais") {
			System.out.println(pCommand);
			pNome = request.getParameter("nome");
			
			if(request.getParameter("populacao") != null) {
				pPopulacao = Long.parseLong(request.getParameter("populacao")); 
				
			}
			if(request.getParameter("area") != null) {
				pArea = Float.parseFloat(request.getParameter("area"));
			}
			
		}
	    
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
	    
	    pais = cs.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

		view.forward(request, response);
	}

}
