package sortieralgorithmen;

public class Test {
	
	public static void main(String[] args) {
		int[] array1, array2, unsArray = new int[10];
		unsArray[0] = -1;
		unsArray[1] = 6;
		unsArray[2] = 9;
		unsArray[3] = 7;
		unsArray[4] = 8;
		unsArray[5] = 5;
		unsArray[6] = 2;
		unsArray[7] = 3;
		unsArray[8] = 4;
		unsArray[9] = 1;
		
		
		System.out.println("\n- Selektion-Sort -");
		System.out.print("zu Sortierendes Array: ");
		gibAus(unsArray);
		
		System.out.print("Rekursiv sortiert:     ");
		array1 = unsArray.clone();
		Selection.sortiereRekursiv(array1, 0);
		gibAus(array1);
		
		System.out.print("Iterativ sortiert:     ");
		array2 = unsArray.clone();
		Selection.sortiereIterativ(array2);
		gibAus(array2);
		
		
		System.out.println("\n- Insertion-Sort -");
		System.out.print("zu Sortierendes Array: ");
		gibAus(unsArray);
		
		System.out.print("Rekursiv sortiert:     ");
		array1 = unsArray.clone();
		Insertion.sortiereRekursiv(array1, 0);
		gibAus(array1);
		
		System.out.print("Iterativ sortiert:     ");
		array2 = unsArray.clone();
		Insertion.sortiereIterativ(array2);
		gibAus(array2);
		
		
		System.out.println("\n- Bubble-Sort -");
		System.out.print("zu Sortierendes Array: ");
		gibAus(unsArray);
		
		System.out.print("Sortiert:              ");
		array1 = unsArray.clone();
		Bubble.sortiere(array1);
		gibAus(array1);
		
	}
	
	
	private static void gibAus(int[] a) {
		System.out.print("< ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println(">");
	}
	
}
