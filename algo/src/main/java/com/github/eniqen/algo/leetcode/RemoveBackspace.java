package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RemoveBackspace {
	public static void main(String[] args) {
	}

    static public boolean backspaceCompare(String S, String T) {
        String x = removeBackspace(S);
        String y = removeBackspace(T);
        System.out.println(x);
        System.out.println(y);
        return x.equals(y);
    }
    
      static String removeBackspace(String s) {
          int backCount = 0;
          StringBuilder sb = new StringBuilder();
          for(int i = s.length() - 1; i >= 0; i--) {
              char ch = s.charAt(i);
              if(ch =='#') {
                  backCount++;
                  continue;
              } else {
                  if(backCount < 1) {
                      sb.append(ch);
                  } else {
                      backCount--;
                  }
              }
          }
      return sb.toString();
	}
}
