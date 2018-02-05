package com.tool;

import java.util.ArrayList;

public class nixudui {
    public static int  merge(int [] a,int [] temp,int left,int mid,int right){
        int sum=0;
        int k=0;
        int low=left;
        int high =mid+1;
           while(high<=right&&low<=mid){
               if (a[high]>=a[low])//一定有等于号，不然会出错
               {

                   temp[left+k]=a[low];
                   k++;
                   low++;
                   sum=sum+(high-mid-1);

               }
               else {
                   temp[left+k]=a[high];
                   k++;
                   high++;
               }

        }
        if (low<=mid){
               for (;low<=mid;low++)
               {
                   temp[left+k]=a[low];
                   k++;
                   if(a[low]>a[right])
                   sum=sum+(right-mid);
               }
        }else{
            for (;high<=right;high++)
            {
                temp[left+k]=a[high];
                k++;
            }
        }

        for (int i=left;i<=right;i++)
        {
            a[i]=temp[i];
        }
         return sum;
    }
public static int mergecount(int [] A,int [] B,int l,int r){
        int mid=(l+r)/2;
        if(r>l){
            int a=mergecount(A,B,l,mid);
            int b=mergecount(A,B,mid+1,r);
            int c=merge(A,B,l,mid,r);
            return a+b+c;

        }

else {return 0;}


}
    public static  int count(int[] A, int n) {
    int [] temp=new int [n];
    int total=mergecount(A,temp,0,n-1);
    return total;





    }

    public static void main(String[] args) {
       int []a={1,2,3,4,5,0,6,7,0};
        System.out.println(count(a,9));

        }
    }

