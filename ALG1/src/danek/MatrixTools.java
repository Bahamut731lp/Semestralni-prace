package danek;

import java.util.Scanner;

/**
 * @author Kevin Daněk
 *
 */
public class MatrixTools {
	private static Scanner rd = new Scanner(System.in);
	private static final double decimalPlaces = 1E-12;
	private static double precision = 0;
	
	/**
	 * Metoda načte matici reálných čísel ze standardního vstupu
	 * @return Matice reálných čísel
	 */
	public static double[][] read() {
		System.out.println("Zadej velikost matice");
		
		int pocetRadku;
		int pocetSloupcu;
		
		//Zajištění, že se zadají správné rozměry
		do {
			pocetRadku = rd.nextInt();
			pocetSloupcu = rd.nextInt();
			
			if (pocetRadku < 1 || pocetSloupcu < 1) {
				System.out.println();
				System.out.printf("Byly zadány neplatné rozměry:%n");
				System.out.printf("Počet řádků: %s%n", pocetRadku);
				System.out.printf("Počet sloupců: %s%n", pocetSloupcu);
				System.out.println("Prosím, zadejte kladné, nenulové rozměry matice");
				continue;
			}
			
			break;
		} while (true);
		
		double[][] matice = new double[pocetRadku][pocetSloupcu];
		System.out.println("Zadej prvky matice po řádcích:");
		
		for (int radek = 0; radek < pocetRadku; radek++) {
			for (int sloupec = 0; sloupec < pocetSloupcu; sloupec++) {
				matice[radek][sloupec] = rd.nextDouble();
			}
		}
		
		updatePrecision(matice);
		
		return matice;
	}
	
	/**
	 * Metoda vypíše formátovanou matici na standardní výstup
	 * @param label Nadpis výstupu matice
	 * @param matrix Matice, která se má naformátovat a vypsat
	 */
	public static void print(String label, double[][] matrix) {
		System.out.println(label);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%s ", matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/**
	 * Metoda transponuje matici v argumentu
	 * @param matrix
	 * @return
	 */
	public static double[][] transpose(double[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		
		double[][] transposedMatrix = new double[colCount][rowCount];
		
		for (int radek = 0; radek < matrix.length; radek++) {
			for (int sloupec = 0; sloupec < matrix[radek].length; sloupec++) {
				transposedMatrix[sloupec][radek] = matrix[radek][sloupec];
			}
		}
		
		return transposedMatrix;
	}
	
	/**
	 * Metoda pro porovnání reálných čísel s volitelnou přesností
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean compare(double a, double b) {
		return Math.abs(a - b) <= precision;
	}

	/**
	 * Metoda nalezne největší absolutní hodnotu v matici
	 * @param matrix
	 * @return
	 */
	public static double getMaxAbsolute(double[][] matrix) {
		double maximum = Double.NEGATIVE_INFINITY;
		
		for (int radek = 0; radek < matrix.length; radek++) {
			for (double sloupec : matrix[radek]) {
				if (maximum < Math.abs(sloupec)) {
					maximum = Math.abs(sloupec);
				}
			}
		}
		
		return maximum;
	}
	
	/**
	 * Metoda aktualizuje či ponechá přesnost pro další výpočty
	 * @param matrix Matice, pro kterou se vypočítá přesnost
	 */
	public static void updatePrecision(double[][] matrix) {
		double presnostMatice = decimalPlaces * getMaxAbsolute(matrix);
		if (presnostMatice > precision) precision = presnostMatice;
	}
	
	
	/**
	 * Metoda ověří, zda jsou argumenty nazvájem transponované matice
	 * @param matrix První matice k ověření
	 * @param transposition Druhá matice k ověření
	 * @return Boolean, jestli jsou matice nazvájem transponované
	 */
	public static boolean isTransposed(double[][] matrix, double[][] transposition) {
		if (matrix.length != transposition[0].length || matrix[0].length != transposition.length) return false;
		
		boolean isTransposed = true;
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (!compare(matrix[row][column], transposition[column][row])) {
					isTransposed = false;
					break;
				}
			}
		}
		
		return isTransposed;
	}
	
	public static Set getUniqueValues(double[][] matrix) {
		Set uniqueValues = new Set();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				uniqueValues.add(matrix[i][j]);
			}
		}
		
		return uniqueValues;
	}
	
	/**
	 * Metoda spočte počet nulových prvků v matici
	 * @param matrix
	 * @return
	 */
	public static int getNumberOfZeroes(double[][] matrix) {
		int numOfZeroes = 0;
		
		for (int row = 0; row < matrix.length; row++) {
			for (double col : matrix[row]) {
				if (compare(col, 0)) numOfZeroes++;
			}
		}
		
		return numOfZeroes;
	}
	
	/**
	 * Metoda vrátí pole se součty prvků řádků
	 * @param matrix
	 * @return
	 */
	public static double[] getRowSums(double[][] matrix) {
		double[] sums = new double[matrix.length];
		
		for (int row = 0; row < matrix.length; row++) {
			double sum = 0;
			
			for (int col = 0; col < matrix[row].length; col++) {
				sum += matrix[row][col];
			}
			
			sums[row] = sum;
		}
		
		return sums;
	}
	
	/**
	 * Metoda ověří, jestli mají matice stejné rozměry
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameDimensions(double[][] matrix1, double[][] matrix2) {
		return (matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length); 
	}
	
	/**
	 * Metoda zjištuje, jestli matice obsahují stejná čísla
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameValues(double[][] matrix1, double[][] matrix2) {
		Set matrix1Values = getUniqueValues(matrix1);
		Set matrix2Values = getUniqueValues(matrix2);
		
		if (matrix1Values.length != matrix2Values.length) return false;
		
		double[] values = matrix1Values.asArray();
		
		for (int i = 0; i < values.length; i++) {
			if (!matrix2Values.contains(values[i])) return false;
		}
		
		return true;
	}
	
	/**
	 * Metoda porovnává, jestli mají matice stejná znaménka na stejných pozicích
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameSigns(double[][] matrix1, double[][] matrix2) {
		if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) return false;
		
		boolean sameSigns = true;
		for (int row = 0; row < matrix1.length; row++) {
			for (int column = 0; column < matrix1[row].length; column++) {
				if (Math.signum(matrix1[row][column]) != Math.signum(matrix1[row][column])) {
					sameSigns = false;
					break;
				}
			}
		}
		
		return sameSigns;		
	}
	
	/**
	 * Metoda zjištuje, jestli mají matice stejný počet nulových a nenulových prvků
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameZeroes(double[][] matrix1, double[][] matrix2) {
		int matrix1Zeroes = getNumberOfZeroes(matrix1);
		int matrix2Zeroes = getNumberOfZeroes(matrix2);
		
		return compare(matrix1Zeroes, matrix2Zeroes);
	}

	/**
	 * Metoda zjištuje, jestli mají matice stejné součty prvků v řádku
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameSums(double[][] matrix1, double[][] matrix2) {
		if (matrix1.length != matrix2.length) return false;
		
		double[] sums1 = getRowSums(matrix1);
		double[] sums2 = getRowSums(matrix2);
		
		boolean areSame = true;

		for (int i = 0; i < sums1.length; i++) {
			if (sums1[i] != sums2[i]) {
				areSame = false;
				break;
			}
		}
		
		return areSame;
	}

	/**
	 * Metoda porovná, jestli matice v argumentu mají stejné maximální absolutní hodnoty
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static boolean haveSameAbsolutes(double[][] matrix1, double[][] matrix2) {
		double absolute1 = getMaxAbsolute(matrix1);
		double absolute2 = getMaxAbsolute(matrix2);
		
		return compare(absolute1, absolute2);
	}
		
}
