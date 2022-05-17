package danek;

import java.util.Scanner;

public class Main {
	private static Scanner rd = new Scanner(System.in);
	private static double[][] matrix1;
	private static double[][] matrix2;
	
	public static void main(String[] args) {	
		boolean behProgramu = true;
		while (behProgramu) {
			System.out.println("Míry shody matic.");
			System.out.printf("%5s %s%n", "(1)", "Načti první matici.");
			System.out.printf("%5s %s%n", "(2)", "Načti druhou matici.");
			System.out.printf("%5s %s%n", "(3)", "Výpis matic.");
			System.out.printf("%5s %s%n", "(4)", "Testy matic.");
			System.out.printf("%5s %s%n", "(5)", "Konec.");
			System.out.println();
			
			int volba = rd.nextInt();
			
			switch (volba) {
				case 1:
					matrix1 = MatrixTools.read();
					break;
	
				case 2:
					matrix2 = MatrixTools.read();
					break;

				case 3:
					vypisMatice();
					break;
					
				case 4:
					vypisTesty();
					break;
					
				case 5:
					behProgramu = false;
					break;
				default:
					break;
			}
			
		}
	}
	
	public static void vypisMatice() {
		MatrixTools.print("Matice 1", matrix1);
		MatrixTools.print("Matice 2", matrix2);	
	}
	
	public static void vypisTesty() {
		boolean jitZpet = false;
		
		while (!jitZpet) {
			System.out.println("Testy matic.");
			System.out.printf("%5s %s%n", "(1)", "Mají matice shodné rozměry?");
			System.out.printf("%5s %s%n", "(2)", "Mají matice shodné hodnoty?");
			System.out.printf("%5s %s%n", "(3)", "Mají matice shodnou strukturu?");
			System.out.printf("%5s %s%n", "(4)", "Mají matice stejný počet nenulových prvků?");
			System.out.printf("%5s %s%n", "(5)", "Mají matice stejné maximální absolutní hodnoty?");
			System.out.printf("%5s %s%n", "(6)", "Jsou matice navzájem transponované?");
			System.out.printf("%5s %s%n", "(7)", "Jsou součty řádků stejné v obou maticích?");
			System.out.printf("%5s %s%n", "(8)", "Zpět.");
			System.out.println();
			
			int volba = rd.nextInt();
			
			switch (volba) {
				case 1:
					boolean sameDimensions = MatrixTools.haveSameDimensions(matrix1, matrix2);
					System.out.printf("Matice %smají stejné rozměry.%n", sameDimensions ? "" : "ne");
					break;
				
				case 2:
					boolean sameValues = MatrixTools.haveSameValues(matrix1, matrix2);
					System.out.printf("Matice %smají shodné hodnoty.%n", sameValues ? "" : "ne");
					break;
					
				case 3:
					boolean sameSigns = MatrixTools.haveSameSigns(matrix1, matrix2);
					System.out.printf("Matice %smají stejnou strukturu.%n", sameSigns ? "" : "ne");
					break;
				
				case 4:
					boolean sameZeroes = MatrixTools.haveSameZeroes(matrix1, matrix2);
					System.out.printf("Matice %smají stejný počet nulových a nenulových prvků.%n", sameZeroes ? "" : "ne");
					break;
					
				case 5:
					boolean sameAbsolutes = MatrixTools.haveSameAbsolutes(matrix1, matrix2);
					System.out.printf("Matice %smají stejné maximální absolutní hodnoty.%n", sameAbsolutes ? "" : "ne");
					break;
					
				case 6:
					boolean transposed = MatrixTools.isTransposed(matrix1, matrix2);
					System.out.printf("Matice %sjsou navzájem transponované.%n", transposed ? "" : "ne");
					break;
					
				case 7:
					boolean sameSums = MatrixTools.haveSameSums(matrix1, matrix2);
					System.out.printf("Matice %smají stejné součty řádků.%n", sameSums ? "" : "ne");
					break;
					
				case 8:
					jitZpet = true;
				
				default:
					break;
			}	
		}
	}
}
