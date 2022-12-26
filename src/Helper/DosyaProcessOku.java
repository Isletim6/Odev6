package Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Kuyruklar.ProcessItem;

public class DosyaProcessOku {

	public DosyaProcessOku() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<ProcessItem> DosyadanOku(String fileName) throws IOException {
		var process = new ArrayList<ProcessItem>();

		var tamDosyaYolu = System.getProperty("user.dir") + "\\" + fileName;

		File file = new File(tamDosyaYolu);// creates a

		if (!file.exists()) {
			throw new FileNotFoundException(tamDosyaYolu);
		}

		var rn = new Random();
		var RenkList = Renkler.values();

		FileReader fr = new FileReader(file);// reads the file
		BufferedReader br = new BufferedReader(fr);// creates a buffering character input stream

		String line;
		while ((line = br.readLine()) != null) {
			var sd = line.split(",");
			if (sd.length != 3)
				continue;
			var gelisZamani = Integer.parseInt(sd[0].trim());
			var oncelik = Integer.parseInt(sd[1].trim());
			var sure = Integer.parseInt(sd[2].trim());
			var processRenk = RenkList[rn.nextInt(RenkList.length)];

			process.add(new ProcessItem(oncelik, gelisZamani, sure, processRenk));

		}
		fr.close();// closes the stream and release the resources
		return process;
	}

}
