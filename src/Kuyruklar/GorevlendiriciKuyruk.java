package Kuyruklar;

import java.util.ArrayList;

import Helper.ColorWrite;

public class GorevlendiriciKuyruk {
	FcfsKuyruk fcfsKuyruk;
	RoundRobinKuyruk kuyruk1;
	RoundRobinKuyruk kuyruk2;
	RoundRobinKuyruk kuyruk3;
	ProcessItem calisanKuyruk;

	public GorevlendiriciKuyruk() {
		// TODO Auto-generated constructor stub
		fcfsKuyruk = new FcfsKuyruk(0);
		kuyruk1 = new RoundRobinKuyruk(1);
		kuyruk2 = new RoundRobinKuyruk(2);
		kuyruk3 = new RoundRobinKuyruk(3);
	}

///Kuyrağa bir Process ekler.
	public void KuyrugaEkle(ProcessItem process) {
		switch (process.getOncelik()) {
		case 0:
			fcfsKuyruk.KuyrugaEkle(process);
			break;
		case 1:
			kuyruk1.KuyrugaEkle(process);
			break;
		case 2:
			kuyruk2.KuyrugaEkle(process);
			break;
		case 3:
			kuyruk3.KuyrugaEkle(process);
			break;
		}
	}

//Kuyruktan ilgili Process Bulunup işleniyor
	public void Run(int saniye) {
		var process = GetProcess(saniye);
		if (process == null)
			return;

		if (saniye > 20) { //20 Saniye Sonra tüm görevler iptal ediliyor.
			var killList = KillProcess();

			for (var pro : killList) {
				ColorWrite.WriteProcess(pro, saniye, "öldü");
			}

			return;
		}

		if (calisanKuyruk == null || process.id != calisanKuyruk.id) {
			//Daha önce çalışan farklı process var ise askıya alınıyor
			if (calisanKuyruk != null && calisanKuyruk.kalanSure > 0
					&& calisanKuyruk.kalanSure != calisanKuyruk.processSuresi) {
				ColorWrite.WriteProcess(calisanKuyruk, saniye, "askıya alındı");
			}

			//Farklı bir processden gelen işlem ilk adımı ise başlıyor
			if (process.kalanSure == process.processSuresi) {
				ColorWrite.WriteProcess(process, saniye, "başladı");
			}
		}

		getProcessKuyruk.Isle(process);

		if (saniye < 20) {
			//Eğer işlemler ölmedi ise , kalan süresi var ise yürütülüyor
			// Fakat kalan süresi kalmadı ise sonlandırıyor
			var islemAdi = process.kalanSure > 0 ? "yürütülüyor" : "sonlandı ";
			ColorWrite.WriteProcess(process, saniye + 1, islemAdi);
		}
		calisanKuyruk = process;
	}

	Kuyruk getProcessKuyruk = null;

//İlgili saniye için kuyruk önceliklerine göre handi kuyrukta process var ise sonu getiriyor.
	ProcessItem GetProcess(int saniye) {
		var process = fcfsKuyruk.GetProcess(saniye);
		getProcessKuyruk = fcfsKuyruk;
		if (process != null)
			return process;
		process = kuyruk1.GetProcess(saniye);
		getProcessKuyruk = kuyruk1;
		if (process != null)
			return process;
		process = kuyruk2.GetProcess(saniye);
		getProcessKuyruk = kuyruk2;
		if (process != null)
			return process;
		process = kuyruk3.GetProcess(saniye);
		getProcessKuyruk = kuyruk3;
		if (process != null)
			return process;
		getProcessKuyruk = null;
		return null;
	}
	
//Tüm ölmesi gereken process ler bir listeye ekleniyor.
	ArrayList<ProcessItem> KillProcess() {
		var liste = new ArrayList<ProcessItem>();
		liste.addAll(fcfsKuyruk.KillProcess());
		liste.addAll(kuyruk1.KillProcess());
		liste.addAll(kuyruk2.KillProcess());
		liste.addAll(kuyruk3.KillProcess());
		return liste;
	}

}
