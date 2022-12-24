package Kuyruklar;

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

	public void KuyrugaEkle(ProcessItem process) {
		
	}

	public void Run(int saniye) {
		
	}

		

}
