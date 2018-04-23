package com.test;


import java.util.Scanner;


public class Main {

public static int  gcd(int a,int b){
      if(a<b){
          int tmp=a;
          a=b;
          b=tmp;
      }

      if(b==0){
          return a;
      }
      int h=a%b;
      return gcd(b,h);

}

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String[] ss=s.split(" ");
    int N=Integer.parseInt(ss[0]);
    int n=Integer.parseInt(ss[1]);
    int m=Integer.parseInt(ss[2]);
    int p=Integer.parseInt(ss[3]);
    int [] A =new int [N+1];
    A[1]=p;
   for (int j=2;j<=N;j++){
       A[j]=(A[j-1]+153)%p;
   }
int sum=0;
for (int i=1;i<=n;i++){
       for (int j=1;j<=m;j++){
           sum=sum+A[gcd(i,j)];
       }
}


        System.out.println(sum);



    }
}
