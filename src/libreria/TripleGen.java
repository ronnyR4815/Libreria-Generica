package libreria;
/**
 * Esta clase generica recibe hasta tres tipos de parametros.
 * Recibe hasta 9 atributos.
 * Si se instancia la clase sin parametros los
 * atributos inicializan en nulo.
 * @author Ronny Rosero
 * @param <R>
 * @param <S>
 * @param <T>
 * @see SingleGen
 * @see DoubleGen
 */
public class TripleGen<R, S, T> 
{
	private R R1, R2, R3;
	private S S1, S2, S3;
	private T T1, T2, T3;
	
	public TripleGen()
	{
		R1 = null;
		R2 = null;
		R3 = null;
		S1 = null;
		S2 = null;
		S3 = null;
		T1 = null;
		T2 = null;
		T3 = null;
	}
	public TripleGen(R r1, R r2, R r3, S s1, S s2, S s3, T t1, T t2, T t3) 
	{
		R1 = r1;
		R2 = r2;
		R3 = r3;
		S1 = s1;
		S2 = s2;
		S3 = s3;
		T1 = t1;
		T2 = t2;
		T3 = t3;
	}
	public TripleGen(R r1, R r2, S s1, S s2, T t1, T t2) 
	{
		R1 = r1;
		R2 = r2;
		S1 = s1;
		S2 = s2;
		T1 = t1;
		T2 = t2;
	}
	public TripleGen(R r1, S s1, T t1) 
	{
		R1 = r1;
		S1 = s1;
		T1 = t1;
	}
	public TripleGen(R r1, R r2, R r3, S s1, S s2, S s3, T t1, T t2)
	{
		R1 = r1;
		R2 = r2;
		R3 = r3;
		S1 = s1;
		S2 = s2;
		S3 = s3;
		T1 = t1;
		T2 = t2;
	}

	public TripleGen(R r1, R r2, R r3, S s1, S s2, T t1, T t2) 
	{
		R1 = r1;
		R2 = r2;
		R3 = r3;
		S1 = s1;
		S2 = s2;
		T1 = t1;
		T2 = t2;
	}
	public TripleGen(R r1, R r2, S s1, S s2, T t1) 
	{
		R1 = r1;
		R2 = r2;
		S1 = s1;
		S2 = s2;
		T1 = t1;
	}
	public TripleGen(R r1, R r2, S s1, T t1) 
	{
		R1 = r1;
		R2 = r2;
		S1 = s1;
		T1 = t1;
	}
	public R getR1() {
		return R1;
	}
	public void setR1(R r1) {
		R1 = r1;
	}
	public R getR2() {
		return R2;
	}
	public void setR2(R r2) {
		R2 = r2;
	}
	public R getR3() {
		return R3;
	}
	public void setR3(R r3) {
		R3 = r3;
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