// Kuyruk sınıfını ve kütüphaneyi tanıladık
package Kuyruklar;

import java.util.ArrayList;
//Round-robin için sınıf oluşturduk.
public class RoundRobinKuyruk extends Kuyruk {
	// TurCalisanlari nesnesini oluşturduk.
	ArrayList<ProcessItem> TurCalisanlari;
	// Öncelik parametresini çağırdık.
	public RoundRobinKuyruk(int oncelik) {
		super(oncelik);
		// TODO Auto-generated constructor stub
		TurCalisanlari = new ArrayList<ProcessItem>();
		
	}	
	// klon dizi oluşturduk ve süreleri kloana aktardık 
	ArrayList<ProcessItem> zamaniGelmisProcessler(int kontrolSaniye) {
		var clone = new ArrayList<ProcessItem>();
	// Süreye bağlı olarak  kalansüresi 0'a eşit veya geliş zamını kontrol edilen zamandan büyük olunca ekler.
		for (int i = 0; i < processListesi.size(); i++) {
		     ProcessItem process = processListesi.get(i);
		     if (process.kalanSure == 0 || process.gelisSuresi > kontrolSaniye)
			continue;
			clone.add(process);
		}
		return clone;
	}

	// Process liste kontrol, sıralama ve process zamana göre devam etme.
	public ProcessItem GetProcess(int kontrolSaniye)
	{	
		//yeni nesne oluşturduk ve tüm öğeleri ekledik. Sıralamadan sonra ana listesinin bozulmaması için klon oluşturdum.
		ArrayList<ProcessItem> clone = new ArrayList<ProcessItem>();
		clone.addAll(processListesi);
		// Zamanı gelmiş processleri calisabilecek processlere aktardık.
		var calisabilecekProcessler = zamaniGelmisProcessler(kontrolSaniye);
		// Tüm zamanı gelmiş processler çalıştıysa listeyi temizlip baştan alıyoruz.
		if (HepsiCalisti(calisabilecekProcessler))
		   TurCalisanlari.clear();
		// Listeyi sıraladık.
		clone.sort(ProcessItem.getKucukten());
		// Kalan zaman 0'a eşit ya da geliş zamanı kontrol edilen zamandan büyükse devam eder.
		for (int i = 0; i < clone.size(); i++) {
			ProcessItem process = clone.get(i);
			if (process.kalanSure == 0 || process.gelisSuresi > kontrolSaniye)
			    continue;
		// Çalışan processlerin tekrar çalışmaması için kontrol ediyoruz.
			if (TurCalisanlari.contains(process))
			    continue;

			return process;
		}
		return null;
	}

	//  Bu turda çalışması gereken processlerin çalışıp çalışmadığını kontrol eder.
	boolean HepsiCalisti(ArrayList<ProcessItem> calisabilecekProcessler) {
		// döngü ile herbirini kontrol ediyoruz. Bulunmuyorsa false.
		for (ProcessItem pp : calisabilecekProcessler) {
		     if (!TurCalisanlari.contains(pp))
			return false;
		}
		// bulunuyorsa true döndürüyoruz.
		return true;
	}


	// Processs'in kalan zamanı 0 dan büyük varsa TurCalisanlari na ekler.(işlemi bitn processi listeye ekler.)
	@Override
	public void Isle(ProcessItem pp) {				
		pp.ProcessIsle();
		if (pp.getKalanSure() > 0)
		TurCalisanlari.add(pp);
	}	
}
