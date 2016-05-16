package it.uniroma3.modelli;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controllerServizio")
public class ServizioController extends HttpServlet {


	
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		
		String nextPage = null;
		
		//prova servizio
		Servizio servizio1 = new Servizio();
		servizio1.setDescrizione("descrizione");
		servizio1.setNome("servizio1");
		servizio1.setCodice("codice");
		servizio1.setCosto("costo");
		servizio1.setPrerequisito("chiave1", "prereqisito1");
		servizio1.setPrerequisito("chiave2", "prereqisito2");
		
		Servizio servizio2 = new Servizio();
		servizio2.setDescrizione("descrizione");
		servizio2.setNome("servizio2");
		servizio2.setCodice("codice");
		servizio2.setCosto("costo");
		servizio2.setPrerequisito("chiave1", "prereqisito1");
		servizio2.setPrerequisito("chiave2", "prereqisito2");
		
		Servizio servizio3 = new Servizio();
		servizio3.setDescrizione("descrizione");
		servizio3.setNome("servizio3");
		servizio3.setCodice("codice");
		servizio3.setCosto("costo");
		servizio3.setPrerequisito("chiave1", "prereqisito1");
		servizio3.setPrerequisito("chiave2", "prereqisito2");
		
		Servizio servizio4 = new Servizio();
		servizio4.setDescrizione("descrizione");
		servizio4.setNome("servizio4");
		servizio4.setCodice("codice");
		servizio4.setCosto("costo");
		servizio4.setPrerequisito("chiave1", "prereqisito1");
		servizio4.setPrerequisito("chiave2", "prereqisito2");
		
		//selezione servizio
		String serv = request.getParameter("servizio");
		Servizio servizio = null;
		switch(serv){
		case "servizio1":
			servizio = servizio1;
			break;
		case "servizio2":
			servizio = servizio2;
			break;
		case "servizio3":
			servizio = servizio3;
			break;
		case "servizio4":
			servizio = servizio4;
			break;
		}
		request.setAttribute("servizio", servizio);

		nextPage = "/servizio.jsp";

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}