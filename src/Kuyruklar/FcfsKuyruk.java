package Kuyruklar;

import java.util.ArrayList;

public class FcfsKuyruk extends Kuyruk {

	public FcfsKuyruk(int oncelik) {
		super(oncelik);
		// TODO Auto-generated constructor stub
	}


	@Override
	public ProcessItem GetProcess(int kontrolSaniye)
	{			
		ArrayList<ProcessItem> clone =new ArrayList<>();
		clone.addAll(processListesi);						

		//clone process arrayi icerisindeki processleri siralar.  
		clone.sort(ProcessItem.getKucukten());
		
		//sirasi gelen processi return eder. 
		for(int i=0;i<clone.size();i++)
		{
			ProcessItem process=clone.get(i);
			if(process.kalanSure==0 || process.gelisSuresi>kontrolSaniye) continue;
			return process;			
		}
		
		return null;
	}

	//process islenmesini simule eder. 
	@Override
	public void Isle(ProcessItem pp) {
		pp.ProcessIsle();		
	}
	
}

