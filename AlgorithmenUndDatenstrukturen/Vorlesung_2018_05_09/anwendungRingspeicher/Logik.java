package anwendungRingspeicher;

public class Logik {
	
	public static void main(String[] args) {
		int anz_durchlaeufe = 10;
		
		Ringspeicher ring = new Ringspeicher();
		
		for (int j = 1; j <= anz_durchlaeufe; j++) {
			for (int i = 1; i <= j; i++) {
				ring.insert(i);
			}
		}
		
		ring.delete_first(1);
		ring.delete_first(1);
		ring.delete_first(3);
		ring.delete_first(5);
		
		System.out.println("Prüfung der eingegebenen Werte");
		
		for (int i = 1; i <= anz_durchlaeufe+1; i++) {
			System.out.printf("Hat Ring Wert %3d: %b, Anzahl: %3d\n",i,ring.has_value(i),ring.count(i));
		}
	}
}
