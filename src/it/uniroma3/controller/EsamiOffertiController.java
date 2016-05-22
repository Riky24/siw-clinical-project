package it.uniroma3.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.modelli.EsamiOfferti;
import it.uniroma3.modelli.Prerequisito;


@WebServlet("/esamiofferticontroller")
public class EsamiOffertiController extends HttpServlet  {


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Helper helper = new Helper();
//		Action action = new Action();
//		String nextPage = "/inserisciStudente.jsp";
//		if(helper.validate(request, response)){
//			nextPage = action.execute(request);
//		}
//		nextPage = response.encodeURL(nextPage);
//		ServletContext servletContext = getServletContext();
//		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
//		rd.forward(request, response);
//	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//non riesco ad interagire con il database perchè mi causa errore 500
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
		String nextPage = null;
		
		ElencoEsamiOfferti eeo = new ElencoEsamiOfferti();
		eeo.inizializza();
		
		String serv = request.getParameter("tipologiaEsame");
		EsamiOfferti e = null;
		switch(serv){
		case "vista":
			e = eeo.getEsami().get("vi");
			break;
		case "sangue":
			e = eeo.getEsami().get("sa");
			break;
		}
		
		request.setAttribute("tipologiaEsame", e);

		nextPage = "/esameSelezionato.jsp";
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
}
