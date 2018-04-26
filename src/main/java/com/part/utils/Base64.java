package com.part.utils;

public class Base64 {
	private static final int BASELENGTH = 128;
	private static final int LOOKUPLENGTH = 64;
	private static final int TWENTYFOURBITGROUP = 24;
	private static final int EIGHTBIT = 8;
	private static final int SIXTEENBIT = 16;
	private static final int SIXBIT = 6;
	private static final int FOURBYTE = 4;
	private static final int SIGN = -128;
	private static final char PAD = '=';
	private static final boolean fDebug = false;
	private static final byte[] base64Alphabet = new byte[128];
	private static final char[] lookUpBase64Alphabet = new char[64];

	protected static boolean isWhiteSpace(char octect) {
		return octect == 32 || octect == 13 || octect == 10 || octect == 9;
	}

	protected static boolean isPad(char octect) {
		return octect == 61;
	}

	protected static boolean isData(char octect) {
		return octect < 128 && base64Alphabet[octect] != -1;
	}

	protected static boolean isBase64(char octect) {
		return isWhiteSpace(octect) || isPad(octect) || isData(octect);
	}

	public static String encode(byte[] binaryData) {
		if (binaryData == null) {
			return null;
		} else {
			int lengthDataBits = binaryData.length * 8;
			if (lengthDataBits == 0) {
				return "";
			} else {
				int fewerThan24bits = lengthDataBits % 24;
				int numberTriplets = lengthDataBits / 24;
				int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1 : numberTriplets;
				Object encodedData = null;
				char[] arg16 = new char[numberQuartet * 4];
				boolean k = false;
				boolean l = false;
				boolean b1 = false;
				boolean b2 = false;
				boolean b3 = false;
				int encodedIndex = 0;
				int dataIndex = 0;

				byte val2;
				byte arg18;
				byte arg17;
				byte arg20;
				byte arg19;
				for (int val1 = 0; val1 < numberTriplets; ++val1) {
					arg19 = binaryData[dataIndex++];
					arg20 = binaryData[dataIndex++];
					byte arg21 = binaryData[dataIndex++];
					arg18 = (byte) (arg20 & 15);
					arg17 = (byte) (arg19 & 3);
					val2 = (arg19 & -128) == 0 ? (byte) (arg19 >> 2) : (byte) (arg19 >> 2 ^ 192);
					byte val21 = (arg20 & -128) == 0 ? (byte) (arg20 >> 4) : (byte) (arg20 >> 4 ^ 240);
					byte val3 = (arg21 & -128) == 0 ? (byte) (arg21 >> 6) : (byte) (arg21 >> 6 ^ 252);
					arg16[encodedIndex++] = lookUpBase64Alphabet[val2];
					arg16[encodedIndex++] = lookUpBase64Alphabet[val21 | arg17 << 4];
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg18 << 2 | val3];
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg21 & 63];
				}

				byte arg22;
				if (fewerThan24bits == 8) {
					arg19 = binaryData[dataIndex];
					arg17 = (byte) (arg19 & 3);
					arg22 = (arg19 & -128) == 0 ? (byte) (arg19 >> 2) : (byte) (arg19 >> 2 ^ 192);
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg22];
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg17 << 4];
					arg16[encodedIndex++] = 61;
					arg16[encodedIndex++] = 61;
				} else if (fewerThan24bits == 16) {
					arg19 = binaryData[dataIndex];
					arg20 = binaryData[dataIndex + 1];
					arg18 = (byte) (arg20 & 15);
					arg17 = (byte) (arg19 & 3);
					arg22 = (arg19 & -128) == 0 ? (byte) (arg19 >> 2) : (byte) (arg19 >> 2 ^ 192);
					val2 = (arg20 & -128) == 0 ? (byte) (arg20 >> 4) : (byte) (arg20 >> 4 ^ 240);
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg22];
					arg16[encodedIndex++] = lookUpBase64Alphabet[val2 | arg17 << 4];
					arg16[encodedIndex++] = lookUpBase64Alphabet[arg18 << 2];
					arg16[encodedIndex++] = 61;
				}

				return new String(arg16);
			}
		}
	}

	public static byte[] decode(String encoded) {
		if (encoded == null) {
			return null;
		} else {
			char[] base64Data = encoded.toCharArray();
			int len = removeWhiteSpace(base64Data);
			if (len % 4 != 0) {
				return null;
			} else {
				int numberQuadruple = len / 4;
				if (numberQuadruple == 0) {
					return new byte[0];
				} else {
					Object decodedData = null;
					boolean b1 = false;
					boolean b2 = false;
					boolean b3 = false;
					boolean b4 = false;
					boolean d1 = false;
					boolean d2 = false;
					boolean d3 = false;
					boolean d4 = false;
					int i = 0;
					int encodedIndex = 0;
					int dataIndex = 0;

					byte[] arg16;
					byte arg18;
					byte arg17;
					byte arg20;
					byte arg19;
					char arg22;
					char arg21;
					char arg24;
					char arg23;
					for (arg16 = new byte[numberQuadruple * 3]; i < numberQuadruple - 1; ++i) {
						if (!isData(arg21 = base64Data[dataIndex++]) || !isData(arg23 = base64Data[dataIndex++])
								|| !isData(arg22 = base64Data[dataIndex++])
								|| !isData(arg24 = base64Data[dataIndex++])) {
							return null;
						}

						arg17 = base64Alphabet[arg21];
						arg18 = base64Alphabet[arg23];
						arg19 = base64Alphabet[arg22];
						arg20 = base64Alphabet[arg24];
						arg16[encodedIndex++] = (byte) (arg17 << 2 | arg18 >> 4);
						arg16[encodedIndex++] = (byte) ((arg18 & 15) << 4 | arg19 >> 2 & 15);
						arg16[encodedIndex++] = (byte) (arg19 << 6 | arg20);
					}

					if (isData(arg21 = base64Data[dataIndex++]) && isData(arg23 = base64Data[dataIndex++])) {
						arg17 = base64Alphabet[arg21];
						arg18 = base64Alphabet[arg23];
						arg22 = base64Data[dataIndex++];
						arg24 = base64Data[dataIndex++];
						if (isData(arg22) && isData(arg24)) {
							arg19 = base64Alphabet[arg22];
							arg20 = base64Alphabet[arg24];
							arg16[encodedIndex++] = (byte) (arg17 << 2 | arg18 >> 4);
							arg16[encodedIndex++] = (byte) ((arg18 & 15) << 4 | arg19 >> 2 & 15);
							arg16[encodedIndex++] = (byte) (arg19 << 6 | arg20);
							return arg16;
						} else {
							byte[] tmp;
							if (isPad(arg22) && isPad(arg24)) {
								if ((arg18 & 15) != 0) {
									return null;
								} else {
									tmp = new byte[i * 3 + 1];
									System.arraycopy(arg16, 0, tmp, 0, i * 3);
									tmp[encodedIndex] = (byte) (arg17 << 2 | arg18 >> 4);
									return tmp;
								}
							} else if (!isPad(arg22) && isPad(arg24)) {
								arg19 = base64Alphabet[arg22];
								if ((arg19 & 3) != 0) {
									return null;
								} else {
									tmp = new byte[i * 3 + 2];
									System.arraycopy(arg16, 0, tmp, 0, i * 3);
									tmp[encodedIndex++] = (byte) (arg17 << 2 | arg18 >> 4);
									tmp[encodedIndex] = (byte) ((arg18 & 15) << 4 | arg19 >> 2 & 15);
									return tmp;
								}
							} else {
								return null;
							}
						}
					} else {
						return null;
					}
				}
			}
		}
	}

	protected static int removeWhiteSpace(char[] data) {
		if (data == null) {
			return 0;
		} else {
			int newSize = 0;
			int len = data.length;

			for (int i = 0; i < len; ++i) {
				if (!isWhiteSpace(data[i])) {
					data[newSize++] = data[i];
				}
			}

			return newSize;
		}
	}

	public static void main(String[] args) {
		System.out.println(encode("birthDate".getBytes()));
	}

	static {
		int i;
		for (i = 0; i < 128; ++i) {
			base64Alphabet[i] = -1;
		}

		for (i = 90; i >= 65; --i) {
			base64Alphabet[i] = (byte) (i - 65);
		}

		for (i = 122; i >= 97; --i) {
			base64Alphabet[i] = (byte) (i - 97 + 26);
		}

		for (i = 57; i >= 48; --i) {
			base64Alphabet[i] = (byte) (i - 48 + 52);
		}

		base64Alphabet[43] = 62;
		base64Alphabet[47] = 63;

		for (i = 0; i <= 25; ++i) {
			lookUpBase64Alphabet[i] = (char) (65 + i);
		}

		i = 26;

		int j;
		for (j = 0; i <= 51; ++j) {
			lookUpBase64Alphabet[i] = (char) (97 + j);
			++i;
		}

		i = 52;

		for (j = 0; i <= 61; ++j) {
			lookUpBase64Alphabet[i] = (char) (48 + j);
			++i;
		}

		lookUpBase64Alphabet[62] = 43;
		lookUpBase64Alphabet[63] = 47;
	}
}
