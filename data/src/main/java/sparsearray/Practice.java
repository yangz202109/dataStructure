package sparsearray;

import org.junit.Test;

/**
 * @author yangz
 * @date 2022/3/23 - 8:57
 * 二维数组与稀疏数组相互转换
 */
public class Practice {
    @Test
    public void main() {
        /*
         * 创建一个二维数组 6*6 (模拟棋盘)
         * 0:表示没有旗子, 1:表示黑子, 2:表示白子
         * */
        int row = 6;
        int col = 6;
        int[][] checkerboard = new int[row][col];
        checkerboard[0][1] = 1;
        checkerboard[1][2] = 2;
        checkerboard[2][1] = 1;
        checkerboard[2][2] = 2;
        checkerboard[3][2] = 2;

        //打印二维数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(checkerboard[i][j]);
            }
            System.out.print("\n");
        }

        /*
         * 将二维数组转成稀疏数组
         * 1.遍历二维数组 获取非0的个数
         * */
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (checkerboard[i][j] != 0) {
                    sum++;
                }
            }

        }

        System.out.println("有效数: " + sum);

        //2.创建稀疏数组(行数为有效值+1,列固定为3)
        int[][] sparseArr = new int[sum + 1][3];

        //3.给稀疏数组第一行赋值
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;

        int k = 0; //记录是第几行非0数据

        /* 4.遍历二维数组将有效值存放到稀疏数组中 */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (checkerboard[i][j] != 0) {
                    k++;
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
                    sparseArr[k][2] = checkerboard[i][j];
                }
            }

        }

        //打印稀疏数组
        System.out.println("=========稀疏数组============");
        for (int[] ints : sparseArr) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }

      /*
       将稀疏数组恢复成二维数组
       1.根据稀疏数组的第一行的第一和第二列创建二维数组
      */
        int h = sparseArr[0][0];
        int l = sparseArr[0][1];
        int[][] chessArray2 = new int[h][l];

        //给二维数组赋值
        for (int i = 1; i < sparseArr.length; i++) {
            int r = sparseArr[i][0];
            int c = sparseArr[i][1];
            chessArray2[r][c] = sparseArr[i][2];

        }
        //打印还原的二维数组
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(chessArray2[i][j]);
            }
            System.out.println();
        }

    }
}
