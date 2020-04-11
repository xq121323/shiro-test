package suanfa;

import cn.hutool.core.math.MathUtil;

/**
 *
 * 这是一个二维数组，grid[i][j]表示在坐标(i, j)上有grid[i][j]个正方体。
 * 比如例子：[[1, 2], [3, 4]]， grid[0][0] = 1，表示坐标(0, 0)上有1个正方体。
 *          grid[1,1] = 4，表示坐标(1, 1)上有4个正方体。
 *          这么多个正方体叠放在一起，求它们的表面积。
 *          可以直接数完一共有多少个正方体，直接乘以6，然后减去接触面的个数乘以2（一个接触面会耗损2个单位面积）
 * @author Mechrevo
 * @version v1.0
 * 2020/3/25 16:33
 */
public class Solution_892 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        };
        int[][] grid0={{1,0},{0,2}};

        System.out.println(surfaceArea(grid0));
    }

    /**
     * 传入参数必须为 N * N的距阵
     * @param grid
     * @return
     */
    private static int surfaceArea(int[][] grid){
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 计算每个独立的[i][j]的表面积
                res += grid[i][j] * 4;
                if (grid[i][j]>0) {
                    res += 2;
                }
                // 去除重合面积
                // 跟左边比较去最小的值
                if(i > 0){
                    res -= min(grid[i-1][j],grid[i][j]) * 2;
                }
                // 跟前边比较去最小的值
                if(j > 0){
                    res -= min(grid[i][j-1],grid[i][j]) * 2;
                }

            }
        }
        return res;
    }
    private static int min(int a, int b){
        return a<b ? a : b;
    }
}
