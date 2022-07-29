package projeto_at_1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto_at_1.entities.Imoveis_terrenos;

public class Imoveis_terrenosJDBCDAO implements Imoveis_terrenosDAO {

	public void save(Imoveis_terrenos entity) {
		Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into imoveis_terrenos (titulo, endereço, m_quadrados, m_construidos,"
            + " qtd_quartos, qtd_banheiros, v_garagem, preço) values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            String update_sql = "update imoveis_terrenos set titulo = ?, endereço = ?, m_quadrados = ?,"
            		+ "m_construidos = ?, qtd_quartos = ?, qtd_banheiros = ?,  v_garagem = ?, preço = ? where id = ?";
            PreparedStatement pst;
            if (entity.getId() == 0) {
                pst = con.prepareStatement(insert_sql);
            } else {
                pst = con.prepareStatement(update_sql);
                pst.setInt(9, entity.getId());
            }
            
            pst.setString(1, entity.getTitulo());
            pst.setString(2, entity.getEndereco());
            pst.setDouble(3, entity.getMetros_MxM());
            pst.setFloat(4, entity.getM_construidos());
            pst.setInt(5, entity.getQtd_quartos());
            pst.setInt(6, entity.getQtd_banheiros());
            pst.setInt(7, entity.getV_garagem());
            pst.setDouble(8, entity.getPreco());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}
	
/*==============================================================================================================*/	
	public void delete(int id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from imoveis_terrenos where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
/*==============================================================================================================*/	
	public Imoveis_terrenos find(int id) {
		Connection con = null;
        Imoveis_terrenos p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imoveis_terrenos where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
	}
/*==============================================================================================================*/	
	public List<Imoveis_terrenos> findAll() {
		Connection con = null;
        List<Imoveis_terrenos> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imoveis_terrenos";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Imoveis_terrenos>();
            while (rs.next()) {
                Imoveis_terrenos cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
	}
	
/*==============================================================================================================*/	

	public Imoveis_terrenos findByName(String str) {
		Connection con = null;
        Imoveis_terrenos p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imoveis_terrenos where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
		
	}
/*==============================================================================================================*/
	
	public List<Imoveis_terrenos> findAllByName(String str) {
		Connection con = null;
        List<Imoveis_terrenos> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imoveis_terrenos where name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Imoveis_terrenos>();
            while (rs.next()) {
                Imoveis_terrenos cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
		
	}
/*==============================================================================================================*/		
	 private Imoveis_terrenos map(ResultSet rs) throws SQLException {
	        Imoveis_terrenos p = new  Imoveis_terrenos();
	        p.setId(rs.getInt("id"));
	        p.setTitulo(rs.getString("titulo"));
	        p.setEndereco(rs.getString("endereço"));
	        p.setMetros_MxM(rs.getFloat("m_quadrados"));
	        p.setM_construidos(rs.getFloat("m_construidos"));
	        p.setQtd_quartos(rs.getInt("qtd_quartos"));
	        p.setQtd_banheiros(rs.getInt("qtd_banheiros"));
	        p.setV_garagem(rs.getInt("v_garagem"));
	        p.setPreco(rs.getDouble("preço"));
	        
	        return p;
	    }
	

}
