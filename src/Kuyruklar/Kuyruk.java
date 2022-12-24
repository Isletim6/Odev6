package Kuyruklar;

import java.util.ArrayList;

public abstract class Kuyruk {
	
	ArrayList<ProcessItem> processListesi;
	int Oncelik;	

	public void KuyrugaEkle(ProcessItem process)
	{
		processListesi.add(process);
	}
	
	public Kuyruk(int oncelik) {
		super();
		this.processListesi = new ArrayList<ProcessItem>();
		Oncelik = oncelik;
	}

	public int getOncelik() {
		return Oncelik;
	}
	
	public boolean HasProcess(int kontrolSaniye)
	{		
		for(int i=0;i<processListesi.size();i++)
		{
			ProcessItem process=processListesi.get(i);
			if(process.kalanSure==0 || process.gelisSuresi>kontrolSaniye) continue;
			return true;			
		}
		
		return false;
	}	
	
	public ArrayList<ProcessItem> KillProcess()
	{
		var liste=new ArrayList<ProcessItem>();
		
		for(int i=0;i<processListesi.size();i++)
		{
			ProcessItem process=processListesi.get(i);
			if(process.kalanSure==0 || process.getIsKilled() ) continue;
			process.setIsKilled(true);
			liste.add( process);	
		}
		
		return liste;
	}
	
	abstract public ProcessItem GetProcess(int kontrolSaniye);
	abstract public void Isle(ProcessItem pp) ;	
	 
}
