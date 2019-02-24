package com.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    /*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

            For example, given
    s ="catsanddog",
    dict =["cat", "cats", "and", "sand", "dog"].

    A solution is["cats and dog", "cat sand dog"].*/
    public static void wordBreak(ArrayList<String> result, int begin, ArrayList<String> list, String s, Set<String> dict, boolean[] flag){
        if(s.length()==0){
            StringBuilder sb=new StringBuilder();
            for (String sf:list) {
                sb.append(sf+" ");
            }
            String h=sb.substring(0,sb.lastIndexOf(" "));
            result.add(h);
        }
        int l=s.length();
        for (int i = 1; i <=l ; i++) {

            String ss=s.substring(0,i);
            String res=s.substring(i);
            if(dict.contains(ss)){
                list.add(ss);
                int size=result.size();
                if(!flag[begin+i]){
                    wordBreak(result,i,list,res,dict,flag);
                    list.remove(list.size()-1);
                    if(result.size()==size){
                        flag[begin+i]=true;
                    }
                }
            }
        }
    }

    static Set<String> dict=new HashSet<String>();
    static{dict.add("aaaa");
        dict.add("aaa");
    }
    public static void main(String[] args) {
        String s="aaaaaaa";
        ArrayList<String> result=new ArrayList<String>();
        ArrayList<String> list=new ArrayList<String>();
        boolean[] flag = new boolean[s.length()+1];
        wordBreak(result,0,list,s,dict,flag);


        System.out.println(result.toString());

    }

}
