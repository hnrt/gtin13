// Copyright (c) 2025 Hideaki Narita

package com.hideakin.gtin13;

public class Gtin13 {

	public static char computeCheckDigit(String s) {
		if (s.length() < 12) {
			throw new RuntimeException("GTIN-13: Too short string.");
		}
		int sum0 = x(s, 0) + x(s, 2) + x(s, 4) + x(s, 6) + x(s, 8) + x(s, 10);
		int sum1 = x(s, 1) + x(s, 3) + x(s, 5) + x(s, 7) + x(s, 9) + x(s, 11);
		return "0987654321".charAt((sum0 + sum1 * 3) % 10);
	}

	private static int x(String s, int index) {
		char c = s.charAt(index);
		if (Character.isDigit(c)) {
			return c - '0';
		} else {
			throw new RuntimeException(String.format("GTIN-13: Too short string at %d.", index));
		}
	}

}

