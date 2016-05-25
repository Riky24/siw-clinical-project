package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.modelli.Utente;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		// leggo i parametri
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//verifica dei dati
		boolean ciSonoErrori = false;
		String nextPage = null;
		if(password.equals("")){
			ciSonoErrori = true;
			request.setAttribute("passwordError", "Password obbligatoria");
		}
		if(username.equals("")){
			ciSonoErrori = true;
			request.setAttribute("usernameError", "Username obbligatorio");
		}

		if(ciSonoErrori){
			nextPage = "/effettuaLogin.jsp";
		}
		else{
			Utente u;
			try {
				VerificaLogin f = new VerificaLogin();
				u = f.login(username, password);

				if(u!= null){


					HttpSession sessione = request.getSession();
					sessione.setAttribute("utente", u);    // parametro utente accessibile da ogni classe

					String ruolo = u.getRuolo();
					if(ruolo.equals("admin")){
						nextPage = "/provaLogin.jsp";                        // DA COMPLETARE
					}
					if(ruolo.equals("user")){
						nextPage = "/provaLogin.jsp";                        // DA COMPLETARE
					}
				}else{
					request.setAttribute("loginError", "User o password errati");
					nextPage = "/effettuaLogin.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}