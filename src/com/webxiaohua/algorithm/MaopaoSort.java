/**
 * @desc 冒泡排序，时间复杂度
 */
package com.webxiaohua.algorithm;

import java.util.Random;

public class MaopaoSort {

    public static void main(String... args){
        //int[] source = new int[]{5,4,3,2,1};
        int[] source = new int[]{1,2,3,4,5};
        /*int[] source = new int[500];
        Random random = new Random();
        for(int i=0;i<source.length;i++){
            source[i] = random.nextInt(100000);
        }*/
        int counts = 0;
        long start = System.currentTimeMillis();
        // 外层循环控制轮数
        for(int i=0;i < source.length-1;i++){
            // 内层循环控制每一轮比较次数
            for(int j=0;j < source.length-1-i;j++){
                counts++;
                if(source[j] > source[j+1]){
                    int tmp = source[j];
                    source[j] = source[j+1];
                    source[j + 1] = tmp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("共排序："+counts+"次,耗时："+(end - start)+"毫秒");
        /*for (int i: source) {
            System.out.println(i);
        }*/

    }
}
