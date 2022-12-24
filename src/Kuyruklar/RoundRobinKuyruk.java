package Kuyruklar;

public class RoundRobinKuyruk extends Kuyruk {

	ArrayList<ProcessItem> TurCalisanlari;

	public RoundRobinKuyruk(int oncelik) {
		super(oncelik);
		// TODO Auto-generated constructor stub
		TurCalisanlari = new ArrayList<ProcessItem>();
		
	}	
	
	ArrayList<ProcessItem> zamaniGelmisProcessler(int kontrolSaniye) {
		var clone = new ArrayList<ProcessItem>();

		for (int i = 0; i < processListesi.size(); i++) {
		     ProcessItem process = processListesi.get(i);
		     if (process.kalanSure == 0 || process.gelisSuresi > kontrolSaniye)
			continue;
			clone.add(process);
		}
		return clone;
	}

	
	public ProcessItem GetProcess(int kontrolSaniye)
	{		
		ArrayList<ProcessItem> clone = new ArrayList<ProcessItem>();
		clone.addAll(processListesi);

		var calisabilecekProcessler = zamaniGelmisProcessler(kontrolSaniye);

		if (HepsiCalisti(calisabilecekProcessler))
		   TurCalisanlari.clear();

		clone.sort(ProcessItem.getKucukten());

		for (int i = 0; i < clone.size(); i++) {
			ProcessItem process = clone.get(i);
			if (process.kalanSure == 0 || process.gelisSuresi > kontrolSaniye)
			    continue;

			if (TurCalisanlari.contains(process))
			    continue;

			return process;
		}
		return null;
	}
	
	boolean HepsiCalisti(ArrayList<ProcessItem> calisabilecekProcessler) {

		for (ProcessItem pp : calisabilecekProcessler) {
		     if (!TurCalisanlari.contains(pp))
			return false;
		}

		return true;
	}



	@Override
	public void Isle(ProcessItem pp) {				
		pp.ProcessIsle();
		if (pp.getKalanSure() > 0)
		TurCalisanlari.add(pp);
	}	
}
