package week1;

import java.text.DecimalFormat;
public class keliling {

	public static void main(String[] args) {
		System.out.println("Keliling Lingkaran");
		System.out.println("Rumus : phi x diameter");
		System.out.println("phi = 3.14");
		System.out.println("diameter = 10");
		float phi = 3.14f;
		int diameter = 10;
		float hasil = phi * diameter;
		// Angka Desimal Setelah Koma hanya Muncul 2 angka
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.print("hasil = ");
		System.out.print(df.format(hasil));

	}

}
