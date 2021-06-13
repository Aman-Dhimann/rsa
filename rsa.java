package crypto;

import java.util.Scanner;

public class rsa {
	 public static int gcd(int a, int b) 
	    { 
	        if (a == 0) 
	            return b; 
	          
	        return gcd(b%a,a); 
	    } 
	 static String toBin(int d) {
			String o="";
			while (d>0) {
				o+=d%2;
				d=d/2;
			}//this is in the form of lsb to msb
			return o;
		}
	  static int squareandmultipy(int y,String o,int a,int n) {
		  for(int i=0;i<o.length();i++) {
			  
			  if(o.charAt(i)=='1') {
				  y=(a*y)%n;
			  }
			  a=(a*a)%n;
		  }return y;
	  }
public static void main(String []args) {
	Scanner sc=new Scanner(System.in);
	  System.out.println("enter 2 primes");
	  System.out.println("enter p");
	  int p=sc.nextInt();
	  System.out.println("enter q");
	  int q=sc.nextInt();
	  int n=p*q;
	  int phi=(p-1)*(q-1);
	  System.out.println("enter e");
	  int e=sc.nextInt();
	  while  (gcd(e,phi)!=1) {
		  System.out.println("eneter e again");
		  e=sc.nextInt();
	  }System.out.println("enter plaintext");
	  int plain=sc.nextInt();
	  String ex=toBin(e);
	  System.out.println("("+plain+"^"+e+")"+"mod"+n+":");
	  int answer=squareandmultipy(1,ex,plain,n);
	  System.out.println("cipher is "+answer);
	  
	  
}
}
