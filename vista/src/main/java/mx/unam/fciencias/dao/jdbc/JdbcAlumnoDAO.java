/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.dao.jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.unam.fciencias.data.AlumnoDAOInterface;
import mx.unam.fciencias.jdbc.ConnectionFactory;
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.CarreraDto;

/**
 *
 * @author guillermorojas
 */
public class JdbcAlumnoDAO implements AlumnoDAOInterface<AlumnoDto>,Serializable{
    
    private Connection conn;
    private Statement st;
    private ResultSet resultados;
    private PreparedStatement pst;
    
    private static final String SELECT_ALL="SELECT * FROM alumno";
    private static final String INSERT_ONE="insert into alumno (APELLIDOPATERNO,APELLIDOMATERNO,NOMBRE,NUMEROCUENTA) values (?,?,?,?);";
    
     private static final String DELETE_ONE="DELETE FROM alumno WHERE ID=?;";
    
    @Override
    public List<AlumnoDto> selectAll() {
        List<AlumnoDto> alumnos=new ArrayList<AlumnoDto>();
        try{
        conn=ConnectionFactory.getConnection();
        st=conn.createStatement();
        resultados=st.executeQuery(SELECT_ALL);
        
        while(resultados.next()){
            AlumnoDto alumno=new AlumnoDto();
            
            alumno.setId(resultados.getLong("ID"));
            alumno.setNombre(resultados.getString("NOMBRE"));
            alumno.setApellidoMaterno(resultados.getString("APELLIDOMATERNO"));
            alumno.setApellidoPaterno(resultados.getString("APELLIDOPATERNO"));
            alumno.setNumeroCuenta(resultados.getString("NUMEROCUENTA"));
            
            alumnos.add(alumno);
        }
    
        }catch(Exception e){
            e.printStackTrace();
            
        
        }
        finally{
            try{
            resultados.close();
            st.close();
            conn.close();
            }catch(Exception e){}
            
        }
        return alumnos;
    }
    
    @Override
    public void create(AlumnoDto t)  {
        try{
        conn=ConnectionFactory.getConnection();
        pst=conn.prepareStatement(INSERT_ONE);
        
        
        pst.setString(1, t.getApellidoPaterno());
         pst.setString(2, t.getApellidoMaterno());
          pst.setString(3, t.getNombre());
          pst.setString(4, t.getNumeroCuenta());
       
        
        pst.executeUpdate();
        
        
         }catch(Exception e){
            e.printStackTrace();
            
        
        }
        finally{
              try{
            resultados.close();
            st.close();
            conn.close();
            }catch(Exception e){}
        }
    }
    
       @Override
    public void delete(Long t) {
        try{
        conn=ConnectionFactory.getConnection();
        pst=conn.prepareStatement(DELETE_ONE);
        
        
        pst.setLong(1, t);
        
       
        
        pst.executeUpdate();
        
        
         }catch(Exception e){
            e.printStackTrace();
            
        
        }
        finally{
              try{
            resultados.close();
            st.close();
            conn.close();
            }catch(Exception e){}
        }
    }
    
    public static void main(String[] args) throws SQLException {
        JdbcAlumnoDAO jdbc=new JdbcAlumnoDAO();
        
        for(AlumnoDto a:jdbc.selectAll()){
            System.out.println(a);
        }
        AlumnoDto a=new AlumnoDto();
        a.setApellidoMaterno("Gkjkj");
        a.setApellidoPaterno("Mkjkj");
        a.setNombre("Hiiyi");
        a.setNumeroCuenta("123456789");
        
        jdbc.create(a);
        
    }

    
}
