// Paket ve kütüphaneler tanımlandı.
package Kuyruklar;

import java.util.Comparator;

import Helper.Renkler;

public class ProcessItem {
	// Bilgiler için değişkenler oluşturduk.
	static int Sayac = 0;

	int oncelik;
	int id;
	int gelisSuresi;
	int processSuresi;
	int kalanSure; 
	String ProcessName; 
	boolean isKilled; //Sonlandırma

	Renkler renk;
	// Processleri gelis sürelerine göre büyüklüğünü karşılaştırır.
	public static Comparator<ProcessItem> getKucukten() {
		return new Comparator<ProcessItem>() {
			@Override
			public int compare(ProcessItem o1, ProcessItem o2) {
				return o1.getGelisSuresi() - o2.getGelisSuresi();
			}
		};
	}
	// Process değişkenleri tanımladık.
	public ProcessItem(int oncelik, int gelisSuresi, int processSuresi, Renkler renk) {
		super();// Kuyruklarda üst sınıftaki değişimler için.
		this.oncelik = oncelik;
		this.gelisSuresi = gelisSuresi;
		this.processSuresi = processSuresi;
		this.renk = renk;
		this.kalanSure = processSuresi;
		ProcessName = "P" + Sayac; //zamanı sayar ve aşağıda sayacı çalıştırız.
		id=Sayac; 
		Sayac++;
		isKilled=false;
	}
	// Yukarıda belirlenen değişkenler için fonksiyonlar.(isim, kalan süre, öncelik, process süresi ve renkler için.)
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
		
	// Process sonlandırmak için fonksiyonlar. Sonlanıp-sonlanmadığına bakar.
	public boolean getIsKilled() {
		return isKilled;
	}
	
	public void setIsKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}
	// Process kontrolu için id ye göre...
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
	// Kalan zaman için 
	public void ProcessIsle() {
		if (kalanSure > 0)
			kalanSure--;
	}
	// Process bilgilerini yazdırır.
	public String Mesaj() {
		return String.format("(id:%d öncelik:%d kalan süre:%d sn)", id,oncelik, kalanSure);
	}
//0.0000 sn proses başladı (id:0000 öncelik:1 kalan süre:2 sn)
}
