import java.util.Locale;
import java.util.Scanner;

public class matrizes {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("sum or multiplication? (s/m)");
		Character answer = sc.nextLine().charAt(0);
		
		if (answer.equals('s')) {		
			System.out.print("Length: ");
			int n = sc.nextInt();
			
			int[][] matriz1 = new int[n][n]; 
			int[][] matriz2 = new int[n][n]; 
			
			fillMultidimensionalArray(matriz1, n, sc);
			System.out.println("Now, the second two dimensional array.");
			fillMultidimensionalArray(matriz2, n, sc);
			
			printArray(matriz1, matriz1.length, matriz1.length);
			System.out.println("------------");
			printArray(matriz2, matriz2.length, matriz2.length);
			
			System.out.println("------------");
			int[][] summedMatrix = sumMatrices(matriz1, matriz2);
			printArray(summedMatrix, summedMatrix.length, summedMatrix.length);
		} else {
			System.out.print("First Array rows length: ");
			int i = sc.nextInt();
			System.out.print("First Array columns length: ");
			int j = sc.nextInt();
			
			System.out.print("Second Array rows length: ");
			int k = sc.nextInt();
			System.out.print("Second Array columns length: ");
			int l = sc.nextInt();
			
			int[][] matriz1 = new int[i][j]; 
			int[][] matriz2 = new int[k][l]; 
			
			fillMultiplicationArray(matriz1, i, j, sc);
			System.out.println("Now, the second two dimensional array.");
			fillMultiplicationArray(matriz2, k, l, sc);
						
			printArray(matriz1, matriz1.length, matriz1[0].length);
			System.out.println("------------");
			printArray(matriz2, matriz2.length, matriz2[0].length);
			
			System.out.println("------------");
			int[][] multipliedMatrix = multiplyMatrices(matriz1, matriz2);
			printArray(multipliedMatrix, multipliedMatrix.length, multipliedMatrix.length);
		}	
		
		sc.close();
	}

	public static void fillMultidimensionalArray(int[][] arr, int length, Scanner sc) {
		for (int i = 0; i < length; i++){
	        for (int j = 0; j < length; j++){
	    		System.out.printf("Digite o %dº valor da %dº linha da matriz.\n", j + 1 , i + 1);
	            arr[i][j] = sc.nextInt();
	        }
	    }
	}
	
	public static void fillMultiplicationArray(int[][] arr, int rows, int cols, Scanner sc) {
		for (int i = 0; i < rows; i++){
	        for (int j = 0; j < cols; j++){
	    		System.out.printf("Digite o %dº valor da %dº linha da matriz.\n", j + 1 , i + 1);
	            arr[i][j] = sc.nextInt();
	        }
	    }
	}
	
	public static int[][] sumMatrices(int[][] arr1, int[][] arr2){
		int length = arr1.length;
		int[][] summedArr = new int[length][length];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				summedArr[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		return summedArr;
	}
	
	public static int[][] multiplyMatrices(int[][] arr1, int[][] arr2){
		int length = arr1.length;
		int[][] multipliedArr = new int[length][length];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < arr2[0].length; j++) {
				int sum = 0;
				for(int k = 0; k < arr2.length; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				multipliedArr[i][j] = sum;
			}
		}
		
		return multipliedArr;
	}
	
	public static void printArray(int[][] array, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
