package recursion;

/**
 * @author yangz
 * @date 2022/4/11 - 16:06
 * 使用递归解决迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        /*使用二维数组模拟地图*/
        int[][] map = new int[8][7];
        /*1:表示墙,0:表示路*/
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < map.length; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        /*打印地图*/
        show(map);

        setWay(map, 1, 1);

        System.out.println("==========================");
        show(map);
    }

    /**
     * (1,1)开始位置  (6,5)结束位置
     * map[i][j] 为0表示该点没有走过,1表示为墙,2表示可以走,3表示该点已经走过但走不通
     * 球的行走策略：下-->右-->上-->左 ,走不通则回溯
     *
     * @param map 地图
     * @param i   球的横坐标
     * @param j   球的纵坐标
     * @return 找到路返回true, 没有找到返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true; //找到终点
        } else {
            if (map[i][j] == 0) {  //当前这个点没有走过
                /*根据行走策略*/
                map[i][j] = 2;   //假定该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //行走策略都无法走通
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[i][j] !=0 可能是1,2,3
                return false;
            }
        }
    }

    public static void show(int[][] map) {
        /*打印地图*/
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
