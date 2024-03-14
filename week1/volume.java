package week1;

import java.text.DecimalFormat;
public class volume {

	public static void main(String[] args) {
		System.out.println("Volume Tabung");
		System.out.println("Rumus : phi x (r x r) x t");
		
		float phi = 3.14f;
		System.out.println("phi = 3.14");
		
		System.out.println("diameter = 5");
		float diameter = 5;
		float r = diameter/2;
		System.out.print("r = ");
		System.out.println(r);
		
		int tinggi = 10;
		System.out.println("tinggi = 10");
		
		float hasil = phi*(r*r)*tinggi;
		
		// Angka Desimal Setelah Koma hanya Muncul 2 angka
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.print("hasil = ");
		System.out.print(df.format(hasil));

	}

}
