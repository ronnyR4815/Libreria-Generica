package libreria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase funciona para crear archivos o directorios nuevos.
 * Escribe y lee archivos.</p>
 * 1. Constructor sin parametros -> Archivos()</p>
 * 2. Constructor recibe un path -> Archivos(String pathname)</p>
 * @author Ronny Rosero
 * @see TripleGen
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Archivos implements Configurable
{
	private static TripleGen<File, String, Date> info;
	/** Opcion para Directorios del metodo {@link #create(String, int) create()}*/ 
	public static final int DIR_OPTION = 0;
	/** Opcion para Archivos del metodo {@link #create(String, int) create()}*/
	public static final int FILE_OPTION = 1;

	/**
	 * Constructor de la clase.
	 * Es necesario especificar posteriormente un path {@link #setPath(String) setPath} para utilizar los
	 * metodos de la clase Archivos 
	 */
	public Archivos() {
		info = new TripleGen<File, String, Date>(null, null, new Date());
	}
	/**
	 * Constructor de la clase, recibe un path.
	 * @param pathname - Ruta de archivo o directorio para realizar acciones de
	 * leer archivo, escribir archivo, o crear un archivo/directorio. 
	 */
	public Archivos(String pathname) {
		info = new TripleGen<File, String, Date>(new File(pathname), null, new Date());
	}
	/**
	 * @return Path abstracto como String de texto
	 */
	public String getFilePath()
	{
		if(info.getR1() != null)
			return info.getR1().getPath();
		else
			return null;
	}
	/**
	 * @return Path absoluto como String de texto
	 */
	public String getFileAbsolutePath()
	{
		if(info.getR1() != null)
			return info.getR1().getAbsolutePath();
		else
			return null;
	}
	/**
	 * Asigna un nuevo path base para utilizar los otros metodos de la clase
	 * @param newPath - Se debe especificar un path
	 */
	public void setPath(String newPath)
	{
		info.setR1(new File(newPath));
	}
	/**
	 * Accede a un documento de texto o crea uno nuevo y guarda un String de
	 * texto dentro de este.
	 * @param txt - String de texto que se va a guardar en un documento de texto.
	 * @param permiso - Si permiso = true: Se agrega texto al documento,
	 * 					Si permiso = false: Se sobreescribe el documento.
	 * @return True si y solo si se pudo escribir en el documento de texto.
	 */
	public boolean writeFile(String txt, boolean permiso) 
	{
		try {
			FileWriter f = new FileWriter(info.getR1(), permiso);
			f.write(txt + "\n");
			f.close();
			return true;
		} catch (IOException e) {
			print("Problemas en la escritura", 3);
			return false;
		}
	}
	/**
	 * Accede a un documento de texto o crea uno nuevo y guarda un String de
	 * texto dentro de este.
	 * <p>
	 * <code>Se debe acceder a este metodo de forma estatica.</code>
	 * @param txt - String de texto que se va a guardar en un documento de texto.
	 * @param permiso - Si permiso = true: Se agrega texto al documento,
	 * 					Si permiso = false: Se sobreescribe el documento.
	 * @param path - Se debe especificar un path.
	 * @return True si y solo si se pudo escribir en el documento de texto.
	 */
	public static boolean writeFile(String txt, boolean permiso, String path) 
	{
		try {
			FileWriter f = new FileWriter(path, permiso);
			f.write(txt + "\n");
			f.close();
			return true;
		} catch (IOException e) {
			Configurable.print("Problemas en la escritura", 3);
			return false;
		}
	}
	/**
	 * Accede a un documento de texto, lo lee y devuelve ese texto en
	 * forma de String.
	 * @return String de texto leido de un documento de texto.
	 * @exception FileNotFoundException Si no se encontro la ruta especificada.
	 * @exception IOException Si existieron errores al leer el documento.
	 */
	public String readFile() {
		try {
			BufferedReader stream = new BufferedReader(new FileReader(info.getR1()));
			info.setS1("");
			while(stream.ready() != false) {
				info.setS1(info.getS1() + stream.readLine() + "\n");
			}
			stream.close();
		} catch (FileNotFoundException e) {
			print("Problemas de lectura del archivo", 3);
		} catch (IOException e) {
			print("NO SE ENCONTRÓ EL ARCHIVO", 3);
		}
		return info.getS1();
	}
	/**
	 * Accede a un documento de texto, lo lee y devuelve ese texto en
	 * forma de String.
	 * <p>
	 * <code>Se debe acceder a este metodo de forma estatica.</code>
	 * @param path - Se debe especificar un path.
	 * @return String de texto leido de un documento de texto.
	 * @exception FileNotFoundException Si no se encontro la ruta especificada.
	 * @exception IOException Si existieron errores al leer el documento.
	 */
	public static String readFile(String path) {
		try {
			BufferedReader stream = new BufferedReader(new FileReader(path));
			info.setS1("");
			while(stream.ready() != false) {
				info.setS1(info.getS1() + stream.readLine() + "\n");
			}
			stream.close();
		} catch (FileNotFoundException e) {
			Configurable.print("Problemas de lectura del archivo", 3);
		} catch (IOException e) {
			Configurable.print("NO SE ENCONTRÓ EL ARCHIVO", 3);
		}
		return info.getS1();
	}
	/**
	 * Crea un Archivo o un Directorio segun lo especificado en el path
	 * del constructor.
	 * @param tipo - Si tipo = 0: Crea un directorio. | Si tipo = 1: Crea un archivo.
	 * @return True si y solo si el tipo de directorio especificado
	 * 			se creo satisfactoriamente.
	 * @exception IOException Si no se pudo crear un nuevo archivo en la ruta especificada.
	 */
	public boolean create(int tipo) 
	{
		File f = new File(info.getR1().getPath());
		switch(tipo) {
		case 0:
			if(!f.exists()) {
				return f.mkdir();
			}else {
				print("DIRECTORIO YA EXISTENTE " + f.getName(), 1);
				return false;
			}
		case 1:
			if(!f.exists()) {
				try {
					return f.createNewFile();
				} catch (IOException e) {
					print(e, 1);
				}
			}else {
				print("ARCHIVO YA EXISTENTE " + f.getName(), 1);
				return false;
			}
		default:
			print("OPCIÓN INVÁLIDA " + tipo, 3);
			return false;
		}
	}
	/**
	 * Crea un Archivo o un Directorio segun lo especificado en el path del metodo.
	 * <p>
	 * <code>Se debe acceder a este metodo de forma estatica.</code>
	 * @param path - Se debe especificar un path.
	 * @param tipo - Si tipo = 0: Crea un directorio. | Si tipo = 1: Crea un archivo.
	 * @return True si y solo si el tipo de directorio especificado
	 * 			se creo satisfactoriamente.
	 * @exception IOException Si no se pudo crear un nuevo archivo en la ruta especificada.
	 */
	public static boolean create(String path, int tipo) 
	{
		File f = new File(path);
		switch(tipo) {
		case 0:
			if(!f.exists()) {
				return f.mkdir();
			}else {
				Configurable.print("DIRECTORIO YA EXISTENTE " + f.getName(), 1);
				return false;
			}
		case 1:
			if(!f.exists()) {
				try {
					return f.createNewFile();
				} catch (IOException e) {
					Configurable.print(e.toString(), 1);
				}
			} else {
				Configurable.print("ARCHIVO YA EXISTENTE " + f.getName(), 1);
				return false;
			}
		default:
			Configurable.print("OPCIÓN INVÁLIDA " + tipo, 3);
			return false;
		}
	}
	/**
	 * Busca una expresion regular dentro de un texto.
	 * @param s - String de texto.
	 * @param e - Expresion regular a buscar.
	 * @return String de texto validado por la expresion regular.
	 */
	public boolean validarString(String s, String e) {
		return s.matches(e);
	}
	/**
	 * Busca una palabra dentro de un texto y lo devuelve cambiado por otra expresion.
	 * @param cadena - Es el texto de analisis.
	 * @param replace - Es la palabra por la que se va a reemplazar.
	 * @param palabra - Es la palabra base del patron (Expresion regular).
	 * @return String de texto validado y sobreescrito por la expresion regular.
	 */
	public String replaceString(String cadena, String replace, String palabra) {
		Pattern p = Pattern.compile(palabra);
		Matcher m = p.matcher(cadena);
		return m.replaceAll(replace);
	}
	@Override
	public String autor() {
		return infoAutor();
	}
}