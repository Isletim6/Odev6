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

		clone.sort(ProcessItem.getKucukten());
		
		for(int i=0;i<clone.size();i++)
		{
			ProcessItem process=clone.get(i);
			if(process.kalanSure==0 || process.gelisSuresi>kontrolSaniye) continue;
			return process;			
		}
		
		return null;
	}

	@Override
	public void Isle(ProcessItem pp) {
		pp.ProcessIsle();		
	}
	
}

