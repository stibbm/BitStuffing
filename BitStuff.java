package bitstuff;

import java.util.ArrayList;

public class BitStuff {
	
	/*public static void main(String[] args) {
		ArrayList<Boolean> bits = new ArrayList<>();
		bits.add(false);
		bits.add(true);
		bits.add(true);
		bits.add(true);
		String bitsRep = getBooleanBitsArrayListAsString(bits);
		System.out.println(bitsRep);
		bits.add(2, false);
		bitsRep = getBooleanBitsArrayListAsString(bits);
		System.out.println(bitsRep);
		
	}*/
	
	
	
	
	
	
	public static void main(String[] args) {
		String bitsString = "110101111101011111101011111110";
		ArrayList<Boolean> bits = convertBitsStringToBooleanBitsArray(bitsString);
		bits = bitStuff(bits);
		String bitStuffedString = getBooleanBitsArrayListAsString(bits);
		System.out.println(bitsString);
		System.out.println(bitStuffedString);
		char[] chars = bitStuffedString.toCharArray();
		chars[10] = 'x';
		chars[19] = 'x';
		chars[29] = 'x';
		String bitStuffedStringWithStuffedBitsMarked = new String(chars);
		System.out.println(bitStuffedStringWithStuffedBitsMarked);
		
	}
	
	/** 
	 * Should start with the initial bit value being sent and then should
	 * alternate signal every time a 1 appears
	 * @param bits
	 * @return
	 */
	public static ArrayList<Boolean> makeNRZIBitSequence(ArrayList<Boolean> bits){
		ArrayList<Boolean> NRZIBits = new ArrayList<>();
		boolean prevBit = bits.get(0).booleanValue();
		for(int i=0;i<bits.size();i++) {
			if(i==0) {
				prevBit = bits.get(0).booleanValue();
				NRZIBits.add(bits.get(0).booleanValue());
			}else if(i>0) {
				boolean currBit = bits.get(i).booleanValue();
				boolean currNRZIBit = false;
				if(currBit == true) {
					currNRZIBit = flipBoolean(prevBit);
				}
				NRZIBits.add(currNRZIBit);
				prevBit = currNRZIBit;
			}
		}
		return NRZIBits;
	}
	
	public static boolean flipBoolean(boolean bool) {
		if(bool == true) {
			return false;
		}else if(bool == false) {
			return true;
		}else {
			System.out.println("error");
			System.exit(-1);
			return false;
		}
	}
	
	public static ArrayList<Boolean> convertBitsStringToBooleanBitsArray(String bitsString) {
		ArrayList<Boolean> bits = new ArrayList<>();
		for(int i=0;i<bitsString.length();i++) {
			String charVal = "" + bitsString.charAt(i);
			if(charVal.equals("1")) {
				bits.add(true);
			}
			else if(charVal.equals("0")) {
				bits.add(false);
			}
			else {
				System.out.println("Bad bitstring");
				System.exit(-1);
			}
		}
		
		
		return bits;
	}
	
	public static String getBooleanBitsArrayListAsString(ArrayList<Boolean> bits) {
		String out = "";
		for(int i=0;i<bits.size();i++) {
			if(bits.get(i).booleanValue()==true) {
				out += "1";
			}
			else if(bits.get(i).booleanValue()==false) {
				out += "0";
			}
		}
		return out;
	}

	
	
	public static ArrayList<Boolean> bitStuff(ArrayList<Boolean> bits) {
		for(int i=0;i<bits.size()-6;i++) {
			if(bits.get(i).booleanValue() == false) {
				for(int j=i+1;j<i+6;j++) {
					if(bits.get(j).booleanValue() == false) {
						break;
					}
					if(j==i+5) {
						System.out.println("bit added at index = " + (i+6));
						bits.add(i+6, false);
					}
				}
			}
		}
		return bits;
	}
}
