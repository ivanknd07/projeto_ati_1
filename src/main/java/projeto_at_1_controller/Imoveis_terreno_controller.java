package projeto_at_1_controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


import projeto_at_1.DAO.Imoveis_terrenosDAO;
import projeto_at_1.DAO.Imoveis_terrenosHibernateDAO;
import projeto_at_1.entities.Imoveis_terrenos;

@Path("/imoveis_terrenos")
public class Imoveis_terreno_controller {
	
	  Imoveis_terrenosDAO im_terDAO = new Imoveis_terrenosHibernateDAO();
	  
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Imoveis_terrenos> getAlImoveis_terrenos() {
			return im_terDAO.findAll();
		}
		
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Imoveis_terrenos getById(@PathParam("id") int id) {
			return im_terDAO.find(id);
		}
		
		@GET
	    @Path("/search")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Imoveis_terrenos getByName(@QueryParam("titulo") String titulo) {
	        return im_terDAO.findByName(titulo);
	    }
		
		@POST
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void addProduct(@FormParam("titulo") String titulo,@FormParam("endereço") String endereço,@FormParam("metros_MxM") float metros_MxM, 
				               @FormParam("m_construidos") float m_construidos, @FormParam(" qtd_quartos") int  qtd_quartos, @FormParam("qtd_banheiros") int qtd_banheiros, 
				               @FormParam("v_garagem") int v_garagem,@FormParam("preço") double preço) {
			Imoveis_terrenos imoveis_terrenos = new Imoveis_terrenos(0, titulo, endereço, metros_MxM, m_construidos, qtd_quartos, qtd_banheiros, v_garagem, preço);
			im_terDAO.save(imoveis_terrenos);
		}
		
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void updateImoveis_terrenos(@FormParam("titulo") String titulo,@FormParam("endereço") String endereço,@FormParam("metros_MxM") float metros_MxM, 
	               @FormParam("m_construidos") float m_construidos, @FormParam(" qtd_quartos") int  qtd_quartos, @FormParam("qtd_banheiros") int qtd_banheiros, 
	               @FormParam("v_garagem") int v_garagem,@FormParam("preço") double preço) {
			Imoveis_terrenos imoveis_terrenos = new Imoveis_terrenos(0, titulo, endereço, metros_MxM, m_construidos, qtd_quartos, qtd_banheiros, v_garagem, preço);
			im_terDAO.save(imoveis_terrenos);
		}
		
		@DELETE
		@Path("/{id}")
		public void deleteImoveis_terrenos(@PathParam("id") int id) {
			im_terDAO.delete(id);
		}

}
