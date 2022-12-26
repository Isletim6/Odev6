package main;

import java.io.IOException;
import java.util.ArrayList;

import Helper.DosyaProcessOku;
import Kuyruklar.GorevlendiriciKuyruk;
import Kuyruklar.ProcessItem;

public class Program {

	public Program() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 0) {
			System.out.println("programi kullanmak için programa dosya adını arguman olarak yazınız");
			return;
		}
		ArrayList<ProcessItem> process = new ArrayList<>();
		try {
			process = DosyaProcessOku.DosyadanOku(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GorevlendiriciKuyruk kuyruk = new GorevlendiriciKuyruk();

		for (var pc : process) {
			kuyruk.KuyrugaEkle(pc);
		}		
		
		for (int i = 0; i < 30; i++) {
			kuyruk.Run(i);
		}		
	}

}
