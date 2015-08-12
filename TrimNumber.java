####

package cn.zhou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
/**
 *
* Remove the uselessr  zero of  the number  before and after it, 
* return the truly number.Especially pay attention to the decimal point.
* 
 * @author zhou
 *	 
 */
public class TrimNumber {
 	// 001230.045600  001230.123   000.123   123.456
		//001230  001230.000  001230.
		//000.0        0.0            0.000    0000
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = change(input);
		System.out.println("result is "+result);
		
	}
	public static String change(String str){
	
		int first_real_index =0;
		int last_real_index = str.length()-1;
		char []array = str.toCharArray();
		String rerStr = str;
		
		for(int i=0;i<array.length;i++){
			if(array[i] == '0' && (i+1) < array.length)
				first_real_index = i+1;//指向从左边起到小数点间第一个有效非0的数
			else if(array[i] == '.'){ //不能越过小数点
				first_real_index = i-1;
				break;
			}
			else
				break;
		}
		
		int pointIndex = str.indexOf(".");
		//先判断有无“.”
		//无 “."
		if(pointIndex == -1){
			rerStr = str.substring(first_real_index);
			return rerStr;
		}
		//若有"."
		for(int i=array.length-1;i>=0;i--){
			if(array[i] == '0' || array[i] == '.'){
				last_real_index = i-1; //指向从右边起到小数点间的最后一个有效非0数
				if(array[i] == '.') //不能越过小数点
					break;
			}
			else 
				break;
		}
		System.out.println("first_real_index = "+first_real_index+",last_real_index= "+last_real_index);
		rerStr = str.substring(first_real_index, last_real_index+1);
		
		return rerStr;
	}
}



####
