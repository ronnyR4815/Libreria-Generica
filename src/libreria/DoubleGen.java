package libreria;
/**
 * Esta clase generica recibe dos tipos de parametros.
 * Recibe hasta 6 atributos.
 * Si se instancia la clase sin parametros los
 * atributos inicializan en nulo.
 * @author Ronny Rosero
 * @param <S>
 * @param <T>
 * @see SingleGen
 * @see TripleGen
 */
public class DoubleGen<S, T>
{
	private S S1, S2, S3;
	private T T1, T2, T3;
	
	public DoubleGen()
	{
		this.S1 = null;
		this.S2 = null;
		this.S3 = null;
		this.T1 = null;
		this.T2 = null;
		this.T3 = null;
	}
	public DoubleGen(S S1, S S2, S S3, T T1, T T2, T T3)
	{
		this.S1 = S1;
		this.S2 = S2;
		this.S3 = S3;
		this.T1 = T1;
		this.T2 = T2;
		this.T3 = T3;
	}
	public DoubleGen(S S1, S S2, S S3, T T1, T T2)
	{
		this.S1 = S1;
		this.S2 = S2;
		this.S3 = S3;
		this.T1 = T1;
		this.T2 = T2;
	}
	public DoubleGen(S S1, S S2, T T1, T T2)
	{
		this.S1 = S1;
		this.S2 = S2;
		this.T1 = T1;
		this.T2 = T2;
	}
	public DoubleGen(S S1, S S2, T T1)
	{
		this.S1 = S1;
		this.S2 = S2;
		this.T1 = T1;
	}
	public DoubleGen(S S1, T T1)
	{
		this.S1 = S1;
		this.T1 = T1;
	}
	public S getS1() {
		return S1;
	}
	public void setS1(S s1) {
		S1 = s1;
	}
	public S getS2() {
		return S2;
	}
	public void setS2(S s2) {
		S2 = s2;
	}
	public S getS3() {
		return S3;
	}
	public void setS3(S s3) {
		S3 = s3;
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
}