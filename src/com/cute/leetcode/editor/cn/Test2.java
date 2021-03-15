package com.cute.leetcode.editor.cn;

/**
 * @Author llb
 * Date on 2020/6/28
 */
public class Test2 {
    public boolean isPathCrossing(String path) {
        int row = 0;
        int column = 0;

        if(path.contains("NS") || path.contains("NS") || path.contains("EW") || path.contains("WE"))
            return true;
        for(int i=0;i<path.length();i++) {
            switch(path.charAt(i)) {
                case 'N':
                    column++;
                    break;
                case 'S':
                    column--;
                    break;
                case 'E':
                    row++;
                    break;
                case 'W':
                    row--;
                    break;

            }
            if(row == 0 && column == 0)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test2().isPathCrossing("NNSWWEWSSESSWENNW"));
    }
}
