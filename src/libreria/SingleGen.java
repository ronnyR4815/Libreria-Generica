package libreria;
/**
 * Esta clase generica recibe un solo tipo de parametro.
 * Recibe hasta 4 atributos.
 * Si se instancia la clase sin parametros los
 * atributos inicializan en nulo.
 * @author Ronny Rosero
 * @param <T>
 * @see DoubleGen
 * @see TripleGen
 */
public class SingleGen<T>
{
	private T T1, T2, T3, T4;
	
	public SingleGen()
	{
		this.T1 = null;
		this.T2 = null;
		this.T3 = null;
		this.T4 = null;
	}
	public SingleGen(T T1, T T2, T T3, T T4)
	{
		this.T1 = T1;
		this.T2 = T2;
		this.T3 = T3;
		this.T4 = T4;
	}
	public SingleGen(T T1, T T2, T T3)
	{
		this.T1 = T1;
		this.T2 = T2;
		this.T3 = T3;
	}
	public SingleGen(T T1, T T2)
	{
		this.T1 = T1;
		this.T2 = T2;
	}
	public SingleGen(T T1)
	{
		this.T1 = T1;
	}
	public T getT1() {
		return T1;
	}
	public void setT1(T t1) {
		T1 = t1;
	}
	public T getT2() {
		return T2;
	}
	public void setT2(T t2) {
		T2 = t2;
	}
	public T getT3() {
		return T3;
	}
	public void setT3(T t3) {
		T3 = t3;
	}
	public T getT4() {
		return T4;
	}
	public void setT4(T t4) {
		T4 = t4;
	}
}