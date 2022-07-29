package projeto_at_1.DAO;

import java.util.List;

import projeto_at_1.entities.Imoveis_terrenos;

public interface Imoveis_terrenosDAO {
	
	/*public void save(Imoveis_terrenos entity);

	public void delete(int id);

	public Imoveis_terrenos find(int id);

	public List<Imoveis_terrenos> findAll();

	public Imoveis_terrenos findByName(String str);

	public List<Imoveis_terrenos> findAllByName(String str);
	*/
	public void save(Imoveis_terrenos entity);
	
	public void delete(int id);
	
	public Imoveis_terrenos find (int id);
	
	public List<Imoveis_terrenos> findAll();
	
	public Imoveis_terrenos findByName(String str);
	
	public List<Imoveis_terrenos> findAllByName(String str);

}
