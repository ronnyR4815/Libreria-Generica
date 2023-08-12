package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@SuppressWarnings("unchecked")
public class SQL_Connection 
{
	private SingleGen<Date> datos;
	private String[] param;
	private Connection cn = null;
	private PreparedStatement state = null;
	public Archivos archivos;

	public SQL_Connection() {
		archivos = new Archivos();
		datos = new SingleGen<Date>(new Date());
		archivos.setPath("connection");
		archivos.create(Archivos.DIR_OPTION);
		crearRecurso();
		leerParam();
		open_connection();
	}
	private void crearRecurso() 
	{
		archivos.setPath("connection/config.txt");
		if(archivos.create(Archivos.FILE_OPTION)) {
			archivos.writeFile("#reemplaze por NULL para todos los campos vacios\n"
					+ "ip:localhost\n"
					+ "port:3306\n"
					+ "name:[name db]\n"
					+ "user:root\n"
					+ "psw:NULL\n"
					+ "driver:com.mysql.cj.jdbc.Driver\n\n"
					+ datos.getT1(), false);
		}
	}
	private void leerParam()
	{
		String[] txt = archivos.readFile().split("\n");
		param = new String[txt.length];
		for(int i = 0 ; i < txt.length ; i++) {
			if(!txt[i].contains("#")) {
				if(txt[i].contains(":"))
					param[i] = txt[i].split(":")[1];
				if(txt[i].contains("NULL"))
					param[i] = "";
			}
		}
	}
	private String getURL() {
		return "jdbc:mysql://" + param[1] + ":" + param[2] + "/" + param[3] 
				+ "?user=" + param[4] + "&password=" + param[5]
				+ "&useSSL=false&serverTimezone=UTC";
	}
	public void open_connection() {
		try {
			Class.forName(param[6]);
			cn = DriverManager.getConnection(getURL());
		} catch (ClassNotFoundException e) {
			archivos.print("Error clase no encontrada", 1);
		} catch (SQLException e) {
			archivos.print("Error SQL 1", 1);
		}
	}
	public boolean close_connection() {
		if(cn != null) {
			try {
				cn.close();
				return true;
			} catch (SQLException e) {
				archivos.print("Error SQL 2", 1);
			}
		}
		return false;
	}
	public ResultSet getQuery(String sql)
	{
		ResultSet rs = null;
		try {
			state = cn.prepareStatement(sql);
			rs = state.executeQuery();
		} catch (SQLException e) {
			archivos.print("Error SQL 3", 1);
		}
		return rs;
	}
	public boolean setQuery(String sql)
	{
		try {
			state = cn.prepareStatement(sql);
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			archivos.print("Error SQL 4", 1);
			return false;
		}
	}
}