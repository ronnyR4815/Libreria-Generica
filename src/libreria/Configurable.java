package libreria;

import java.util.Date;
import javax.swing.JOptionPane;
/**
 * Implementa un metodo para agregar al autor del trabajo.
 * @author Ronny Rosero
 *
 * @param <T> Tipo de dato que usa si se desea usar
 * el metodo <code>print()</code>
 */
public interface Configurable<T>
{
	public final String autor = "Ronny A. Rosero F.";
	public final long id = 1725618266;
	public final String nivel = "3ro Programacion Aplicada Grupo 1";
	public final Date date = new Date();
	/**
	 * Si tipo = 1: Imprimira con un salto de linea en consola. |
	 * Si tipo = 2: Imprimira sin salto de linea en consola. |
	 * Si tipo = 3: Imprimira un cuadro de dialogo tradicional. |
	 * @param t - Esto es lo que se imprime
	 * @param tipo - Opcion de impresion
	 */
	public default void print(T t, int tipo)
	{
		switch(tipo) {
		case 1:
			System.out.println(t);
			break;
		case 2:
			System.out.print(t);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, t);
			break;
		default:
			JOptionPane.showMessageDialog(null, "No definido");
			break;
		}
	}
	public static void print(String t, int tipo)
	{
		switch(tipo) {
		case 1:
			System.out.println(t);
			break;
		case 2:
			System.out.print(t);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, t);
			break;
		default:
			JOptionPane.showMessageDialog(null, "No definido");
			break;
		}
	}
	public default String infoAutor()
	{
		return "Desarrollador: " + autor +
				"\nID: " + id +
				"\nNivel: " + nivel +
				"\nFecha: " + date;
	}
	public String autor();
}