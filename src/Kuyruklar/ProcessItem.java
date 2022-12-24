package Kuyruklar;

import java.util.Comparator;

import Helper.Renkler;

public class ProcessItem {

	static int Sayac = 0;

	int oncelik;
	int id;
	int gelisSuresi;
	int processSuresi;
	int kalanSure;
	String ProcessName;
	boolean isKilled;

	Renkler renk;

	public static Comparator<ProcessItem> getKucukten() {
		return new Comparator<ProcessItem>() {
			@Override
			public int compare(ProcessItem o1, ProcessItem o2) {
				return o1.getGelisSuresi() - o2.getGelisSuresi();
			}
		};
	}

	public ProcessItem(int oncelik, int gelisSuresi, int processSuresi, Renkler renk) {
		super();
		this.oncelik = oncelik;
		this.gelisSuresi = gelisSuresi;
		this.processSuresi = processSuresi;
		this.renk = renk;
		this.kalanSure = processSuresi;
		ProcessName = "P" + Sayac;
		id=Sayac;
		Sayac++;
		isKilled=false;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public int getKalanSure() {
		return kalanSure;
	}

	public void setKalanSure(int kalanSure) {
		this.kalanSure = kalanSure;
	}

	public int getOncelik() {
		return oncelik;
	}

	public int getGelisSuresi() {
		return gelisSuresi;
	}

	public int getProcessSuresi() {
		return processSuresi;
	}

	public Renkler getRenk() {
		return renk;
	}
		

	public boolean getIsKilled() {
		return isKilled;
	}

	public void setIsKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof ProcessItem)
		{
			ProcessItem po=(ProcessItem) obj;			
			return po.id==this.id;			
		}
		
		return false;
	}

	public int getId() {
		return id;
	}

	public void ProcessIsle() {
		if (kalanSure > 0)
			kalanSure--;
	}

	public String Mesaj() {
		return String.format("(id:%d öncelik:%d kalan süre:%d sn)", id,oncelik, kalanSure);
	}
//0.0000 sn proses başladı (id:0000 öncelik:1 kalan süre:2 sn)
}
