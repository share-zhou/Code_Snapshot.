###

package cn.zhou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
Given an input string, reverse the string word by word and count the words number
For example,
Given s = i am happy",
print  "happy am i and cnt is 3". 

@since 2015.08.12
@author zhou
**/
public class ReverseWordsAndCount {
public static void main(String[] args) throws IOException {
	ReverseWordsAndCount obj = new ReverseWordsAndCount();
	String s ; //= " you are   happy  ";
	System.out.println("please input words :");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int word=0,num=0;
	if((s= br.readLine()) == null || s.length() == 0)
		return;
	String result = obj.ReverseWords(s);
	int cnt = obj.wordsCount(s);
	System.out.println("reverse  words is "+result+"\n words cnt is "+cnt);
}
public String ReverseWords(String s) {
	   String trim=" "+s.trim();
		char[] chararray=trim.toCharArray();
		String word="";
		StringBuffer buffer=new StringBuffer();
		for (int i = chararray.length-1; i>=0; i--) {

			if(!String.valueOf(chararray[i]).equals(" ")){
				word+=chararray[i];
			}else{

			if(buffer.toString().lastIndexOf(" ")!=buffer.length()-1){
					//如果不是最后一个有空格
					buffer.append(" ");
				}
			//	buffer.append(" ");
				StringBuffer re=new StringBuffer(word);
				re.reverse();
				buffer.append(re);
				word="";
			}
		}
		
	return buffer.toString().trim();
}

	public int wordsCount(String s){
		
		char [] ch = s.toCharArray();
		int word = 0;
		int num = 0;
		// byte []ch = s.getBytes();
		/*for(int k=0;k<ch.length;k++){
			if(ch[k]>='a' && ch[k] <= 'z')
				ch[k] = (char)(ch[k]+'A'-'a');//or '- 32'
			
		}*/
	 //	System.out.println(new String(ch));
		for(int j=0;j<ch.length;j++){
			//if(c[j] == 32){
			if(ch[j] == ' '){	
			word = 0;//是空格
			}else if(word == 0){
				word = 1;//开始出现单词
				num++;
			}
	}
		
	//System.out.println("num="+num);
		return num;
	}

}


###
