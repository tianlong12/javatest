package com.Algorithm;

public class bahuanghou {
    //八皇后问题
    static int [] a=new int[8];
    static int sum=0;
  static  boolean judge(int r)
    {

        for (int i = 0; i < r; i++) {
            if(a[i]==a[r]||(r-i)==Math.abs(a[r]-a[i])){
                return false;
            }

        }
        return true;
    }
    static void quene(int r)
    {
        if (r==8){sum++;}
        else{
            for (int i = 0; i <8 ; i++) {
              a[r]=i;
              if (judge(r)){
                  quene(r+1);
              }
            }
        }
    }







    public static void main(String[] args) {



      quene(0);
        System.out.println(sum);//sum为92
    }
}
