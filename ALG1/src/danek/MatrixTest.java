package danek;

/**
 * @author Kevin Daněk
 *
 */
public class MatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] maticeA = MatrixTools.read();
		double[][] transpozice = MatrixTools.transpose(maticeA);
		
		MatrixTools.print("Matice A:", maticeA);
		MatrixTools.print("Transpozice: ", transpozice);
		
		System.out.println(MatrixTools.isTransposed(maticeA, transpozice));
		
		boolean sameValues = MatrixTools.haveSameValues(maticeA, transpozice);
		System.out.println(sameValues);
	}
}
