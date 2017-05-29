package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import beans.LineOrder;
import beans.Order;
import beans.Product;
//import dao.ProductsDao;

/**
 * Servlet implementation class OrderController
 */

public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< Updated upstream
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException 
//	{
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String action = request.getParameter("action");
//		if(action!=null)
//		{
//						
//			if(action.equals("showForm")){
//				//recuperer la liste Products
//				List<Product> lp = ProductsDao.findAll();
//				request.setAttribute("listeP", lp);
//				//montrer la page achat
//				request.getRequestDispatcher("achatForm.jsp").forward(request, response);
//				
//			}else if(action.equals("showPanier"))
//			{
//				//montre la liste dans une nouvelle page
//				request.getRequestDispatcher("showPanier.jsp").forward(request,response);
//			}else if(action.equals("deleteFromPanier")){
//				int num = Integer.parseInt(request.getParameter("num"));
//				Object o = request.getSession().getAttribute("panier");
//				if(o!=null){
//					Order panier = (Order)o;
//					if(panier.getLignes().size()>num){
//						panier.getLignes().remove(num);
//						request.getSession().setAttribute("panier",panier);
//						/** con l'ultima istruzione ripristiniamo 
//						 * il paniere nella sessione**/
//					}
//				}
//				request.getRequestDispatcher("showPanier.jsp").forward(request, response);
//			}else if(action.equals("removePanier")){
//				//elimino completamente la sessione panier
//				//getSession.invalidate permette di invalidare tutte le variabili di sessione
//				//nel nostro caso abbiamo una sola variabile di sessione: panier
//				//e quindi la eliminiamo con removeAttribute
//				request.getSession().removeAttribute("panier");
//				request.getRequestDispatcher("showPanier.jsp").forward(request, response);
//			}
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//recuperer les parametres: idProduct, qte
//				int idProduct = Integer.parseInt(request.getParameter("idProd"));
//				int qte = Integer.parseInt(request.getParameter("qte"));
//				
//				
//				//ajouter ligne de Order dans le panier
//				LineOrder lc = new LineOrder();
//				lc.setQte(qte);
//				lc.setProd(ProductsDao.find(idProduct));
//				
//				Order panier = null;
//				Object obj = request.getSession().getAttribute("panier");
//				if(obj==null) panier = new Order();
//				else panier = (Order) obj;
//				
//				int position=panier.getLignes().indexOf(lc);
//				//indexOf mi restituisce la posizione dell'elemento lc nella lista panier
//				if(position==-1)
//					//se non ho ancora scelto quel prodotto lo aggiungo
//					panier.getLignes().add(lc);
//				else{
//					//se il prodotto esiste già nel paniere aggiorno la quantità
//					int newQty=lc.getQte() + panier.getLignes().get(position).getQte();
//					panier.getLignes().get(position).setQte(newQty);
//				}
//				request.getSession().setAttribute("panier", panier);
//				
//				List<Product> lp = ProductsDao.findAll();
//				request.setAttribute("listeP", lp);
//				//montrer la page achat
//				request.getRequestDispatcher("achatForm.jsp").forward(request, response);
//				
//		doGet(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
=======
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action!=null)
		{
						
			if(action.equals("show"))
			{
				//recuperer la liste Products
				//List<Product> lp = ProductsDao.findAll();
				//request.setAttribute("listeP", lp);
				//montrer la page achat
				request.getRequestDispatcher("WEB-INF/Views/achat.jsp").forward(request, response);
				
			}
			else if(action.equals("showPanier"))
			{
				//montre la liste dans une nouvelle page
				request.getRequestDispatcher("showPanier.jsp").forward(request,response);
			}
			else if(action.equals("removeProduct"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Object o = request.getSession().getAttribute("panier");
				
				if(o!=null)
				{
					Order panier = (Order)o;
					if(panier.getLignes().size()>num){
						panier.getLignes().remove(num);
						request.getSession().setAttribute("panier",panier);
						/** con l'ultima istruzione ripristiniamo 
						 * il paniere nella sessione**/
					}
				}
				request.getRequestDispatcher("WEB-INF/Views/panier.jsp").forward(request, response);
			}
			else if(action.equals("removePanier"))
			{
		
				request.getSession().removeAttribute("panier");
				request.getRequestDispatcher("WEB-INF/Views/panier.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//recuperer les parametres: idProduct, qte
				int idProduct = Integer.parseInt(request.getParameter("idProd"));
				int qte = Integer.parseInt(request.getParameter("qte"));
				
				
				//ajouter ligne de Order dans le panier
				LineOrder lc = new LineOrder();
				lc.setQte(qte);
				lc.setProd(ProductsDao.find(idProduct));
				
				Order panier = null;
				Object obj = request.getSession().getAttribute("panier");
				if(obj==null) panier = new Order();
				else panier = (Order) obj;
				
				int position=panier.getLignes().indexOf(lc);
				//indexOf mi restituisce la posizione dell'elemento lc nella lista panier
				if(position==-1)
					//se non ho ancora scelto quel prodotto lo aggiungo
					panier.getLignes().add(lc);
				else{
					//se il prodotto esiste già nel paniere aggiorno la quantità
					int newQty=lc.getQte() + panier.getLignes().get(position).getQte();
					panier.getLignes().get(position).setQte(newQty);
				}
				request.getSession().setAttribute("panier", panier);
				
				List<Product> lp = ProductsDao.findAll();
				request.setAttribute("listeP", lp);
				//montrer la page achat
				request.getRequestDispatcher("achatForm.jsp").forward(request, response);
				
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
>>>>>>> Stashed changes

}
