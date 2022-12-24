package Helper;

import Kuyruklar.ProcessItem;

public final class ColorWrite {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void Write(Renkler r, String mesaj) {
		switch (r) {
		case Kirmizi:
			System.out.print(ANSI_RED);
			break;
		case Yesil:
			System.out.print(ANSI_GREEN);
			break;
		case Sari:
			System.out.print(ANSI_YELLOW);
			break;
		case Mavi:
			System.out.print(ANSI_BLUE);
			break;
		case Mor:
			System.out.print(ANSI_PURPLE);
			break;
		case Cyan:
			System.out.print(ANSI_CYAN);
			break;
		case Siyah:
			System.out.print(ANSI_BLACK);
			break;
		}
		System.out.print(mesaj);
		System.out.println(ANSI_RESET);
	}

	public static void WriteProcess(ProcessItem process, int saniye, String islemAdi) {
		var messageText = String.format("%d sn process %s %s", saniye, islemAdi, process.Mesaj());
		Write(process.getRenk(), messageText);
	}

}
