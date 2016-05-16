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

		/*// leggo i parametri
		//String nome = request.getParameter("nome");
		//String descrizione = request.getParameter("descrizione");
		//String codice = request.getParameter("codice");
		//String costo = request.getParameter("costo");
		
		//verifica dei dati
		boolean ciSonoErrori = false;
		String nextPage = null;
		if(codice.equals("")){
			ciSonoErrori = true;
			request.setAttribute("matricolaError", "Matricola obbligatoria");
		}
		if(nome.equals("")){
			ciSonoErrori = true;
			request.setAttribute("nomeError", "Nome obbligatorio");
		}
		if(descrizione.equals("")){
			ciSonoErrori = true;
			request.setAttribute("cognomeError", "Cognome obbligatorio");
		}
		
		if(ciSonoErrori){
			nextPage = "/NewStudente.jsp";
		}
		else{

			//tutti i dati sono corretti
			Servizio servizio = new Servizio();
			servizio.setCognome(descrizione);
			servizio.setNome(nome);
			servizio.setMatricola(codice);

			request.setAttribute("studente", servizio);
			nextPage = "/studente.jsp";
		}
		*/
		
		String nextPage = null;
		
		//prova servizio
		Servizio servizio1 = new Servizio();
		servizio1.setDescrizione("descrizione");
		servizio1.setNome("servizio1");
		servizio1.setCodice("codice");
		servizio1.setCosto("costo");
		//servizio.setPrerequisito("digiuno 12", "il paziente deve essere a digiuno da 12 ore");
		
		Servizio servizio2 = new Servizio();
		servizio2.setDescrizione("descrizione");
		servizio2.setNome("servizio2");
		servizio2.setCodice("codice");
		servizio2.setCosto("costo");
		
		//selezione servizio
		String serv = request.getParameter("servizio");
		System.out.println(serv);
		/*if(serv.equals("servizio1"))
			request.setAttribute("servizio", servizio1);
		else request.setAttribute("servizio", servizio2);
		*/
		request.setAttribute("servizio", servizio1);

		nextPage = "/servizio.jsp";

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}