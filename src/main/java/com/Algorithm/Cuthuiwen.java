package com.Algorithm;

import java.util.ArrayList;

public class Cuthuiwen {public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();

        if (s == null || s.length() == 0)
            return result;

        calResult(result,list,s);
        return result;
    }

    /**
     * 判断一个字符串是否是回文字符串
     */
    private boolean isPalindrome(String str){

        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 回溯
     * @param result : 最终要的结果集 ArrayList<ArrayList<String>>
     * @param list : 当前已经加入的集合 ArrayList<String>
     * @param str : 当前要处理的字符串
     */
    private void calResult(ArrayList<ArrayList<String>> result
            , ArrayList<String> list
            , String str)
    {
        //当处理到传入的字符串长度等于0,则这个集合list满足条件，加入到结果集中
        if (str.length() == 0)
            result.add(new ArrayList<String>(list));
        int len = str.length();
        //递归调用
        //字符串由前往后，先判断str.substring(0, i)是否是回文字符串
        //如果是的话，继续调用函数calResult，把str.substring(i)字符串传入做处理
        for (int i=1; i<=len; ++i){
            String subStr = str.substring(0, i);
            if (isPalindrome(subStr)){
                list.add(subStr);
                String restSubStr = str.substring(i);
                calResult(result,list,restSubStr);
                list.remove(list.size()-1);
            }
        }
    }
}

}
