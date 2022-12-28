package Kuyruklar;

import java.util.ArrayList;

///Kuyruk işlemlerinin temel classıdır
public abstract class Kuyruk {
	
	///Kuyruktaki process Listesidir
	ArrayList<ProcessItem> processListesi;

	/// Kuyrugun Önceliği
	int Oncelik;	

	///Kuyruğa Yeni Bir Process ekler
	public void KuyrugaEkle(ProcessItem process)
	{
		processListesi.add(process);
	}
	
	///Kuyruk Yapıcısı
	public Kuyruk(int oncelik) {
		super();
		this.processListesi = new ArrayList<ProcessItem>();
		Oncelik = oncelik;
	}

	///Kuyruk Öncelik Sırası
	public int getOncelik() {
		return Oncelik;
	}
	
	///Kontrol saniyesi için, aktif çalışacak process olup olmadığı kontrolu
	public boolean HasProcess(int kontrolSaniye)
	{		
		for(int i=0;i<processListesi.size();i++)
		{
			ProcessItem process=processListesi.get(i);
			//Eğer process bitmiş ise veya daha çalışma zamanı gelmediyse işlem yapmadan bir döngü başına döner.
			if(process.kalanSure==0 || process.gelisSuresi>kontrolSaniye) continue;
			return true;			
		}
		
		return false;
	}	
	
	/// Zaman Aşımı olduğunda Kuyruktaki tüm processler öldülürüyor.
	public ArrayList<ProcessItem> KillProcess()
	{
		var liste=new ArrayList<ProcessItem>();
		
		for(int i=0;i<processListesi.size();i++)
		{
			ProcessItem process=processListesi.get(i);
			/// işlem bitti ise veya işlem öldü ise , devam ediyor.
			if(process.kalanSure==0 || process.getIsKilled() ) continue;
			process.setIsKilled(true);
			liste.add( process);	
		}
		
		return liste;
	}
	
	///Türetilen Sınıfta Saniye için İşlenecek Processin bulunması
	abstract public ProcessItem GetProcess(int kontrolSaniye);
	
	// verilen process'in işlenmesi
	abstract public void Isle(ProcessItem pp) ;
	 
}
