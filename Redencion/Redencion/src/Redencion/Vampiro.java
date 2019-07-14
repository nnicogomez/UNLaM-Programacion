package Redencion;

import java.util.Arrays;

public class Vampiro {
	
	public static int cantDigitos(long num){
        return Long.toString(Math.abs(num)).length();
    }
 
    public static boolean buscarVampiro(long orig, long fang1, long fang2){
        if(Long.toString(fang1).endsWith("0") && Long.toString(fang2).endsWith("0")) return false;
 
        int origLen = cantDigitos(orig);
        if(cantDigitos(fang1) != origLen / 2 || cantDigitos(fang2) != origLen / 2) return false;
 
        byte[] origBytes = Long.toString(orig).getBytes();
        byte[] fangBytes = (Long.toString(fang1) + Long.toString(fang2)).getBytes();
        Arrays.sort(origBytes);
        Arrays.sort(fangBytes);
        return Arrays.equals(origBytes, fangBytes);
    }
}