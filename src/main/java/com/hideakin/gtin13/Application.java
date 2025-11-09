package com.hideakin.gtin13;

public class Application {

	public static void main(String[] args) {
		int errors = 0;
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			try {
				char cd = Gtin13.ComputeCheckDigit(s);
				if (s.length() == 12) {
					System.out.printf("%s%c\n", s, cd);
				} else if (s.charAt(12) == cd) {
					System.out.printf("%s OK\n", s.substring(0, 13));
				} else {
					System.out.printf("%s INCORRECT(%c)\n", s.substring(0, 13), cd);
					errors++;
				}
			} catch (Exception e) {
				System.out.printf("%s: ERROR: %s\n", s, e.getMessage());
				errors++;
			}
		}
		System.exit(errors);
	}

}
