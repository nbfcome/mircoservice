/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.nbf.inner.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
* @author nbf
*
* (1)、插入排序：直接插入排序、二分法插入排序、希尔排序。
* (2)、选择排序：简单选择排序、堆排序。
* (3)、交换排序：冒泡排序、快速排序。
* (4)、归并排序
* (5)、基数排序
*/

public class InnerSort {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz" };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    /**
     * 总结：
    一、稳定性:
    稳定：冒泡排序、插入排序、归并排序和基数排序
    不稳定：选择排序、快速排序、希尔排序、堆排序
    二、平均时间复杂度
    O(n^2):直接插入排序，简单选择排序，冒泡排序。
    在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。
    O(nlogn):快速排序，归并排序，希尔排序，堆排序。
    其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。
    三、排序算法的选择
    1.数据规模较小
    （1）待排序列基本序的情况下，可以选择直接插入排序；
    （2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡
    2.数据规模不是很大
    （1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，快速排序，此时要付出log（N）的额外空间。
    （2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序
    3.数据规模很大
    　（1）对稳定性有求，则可考虑归并排序。
    　　（2）对稳定性没要求，宜用堆排序
    4.序列初始基本有序（正序），宜用直接插入，冒泡
     */
    public static void main(String args[]) {
        InnerSort innerSort = new InnerSort();
        //        innerSort.directInsertSort();
        //        innerSort.binarySearchSort();
        //        innerSort.hillSort();
        //        innerSort.directChioceSort();
        //        innerSort.headSort();
        //        innerSort.bubblingSort();
//        innerSort.quickSort();
        innerSort.letterCombinations("23");
    }

    /**
     * •思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置，直到全部插入排序完为止。
     * •关键问题：在前面已经排好序的序列中找到合适的插入位置。
     * •方法：
     * –直接插入排序
     * –二分插入排序
     * –希尔排序
     *
     */

    /**
     * 直接插入排序（从后向前找到合适位置后插入）
     * 1、基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     * 2、复杂度：最优O(n)，最差O(n的2次方) ，平均O(n的2次方)
     * 3、稳定
     */
    protected void directInsertSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };

        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j = 0;
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                //将大于temp的往后移动一位
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }

        this.print(a);
    }

    /**
     * 二分法插入排序（按二分法找到合适位置插入）
     * 1、基本思想：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。
     * 2、复杂度：最优O(n)，最差O(n的2次方/2) ，平均O(n的2次方)
     * 3、稳定
     */
    protected void binarySearchSort() {
        int[] a = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;

            //定位插入位置 left
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            //从定位的left的数据位置往后移
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }

            if (left != i) {//稳定排序
                a[left] = temp;
            }
        }

        this.print(a);
    }

    /**
     * 1、基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。
     *   先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有
     *   记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
     *   2、杂度：最优O(n)，最差O(n的2次方/2) ，平均O(nlogn)
     *   3、不稳定
     */
    protected void hillSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        int d = a.length;

        while (true) {
            d = d / 2;

            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
        }

        this.print(a);
    }

    /**
     * 选择排序
     * •思想：每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。
     * •关键问题：在剩余的待排序记录序列中找到最小关键码记录。
     * •方法：
     * –直接选择排序
     * –堆排序
     * 
     */

    /**
     * 1、基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的
     *    与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     * 2、杂度：最优O(n)，最差O(n的2次方/2) ，平均O(nlogn)
     * 3、不稳定
     */
    protected void directChioceSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n = i; //最小数的索引

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) { //找出最小的数
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;
        }

        this.print(a);
    }

    /**
     * 1、基本思想
     * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     * 堆的定义下：具有n个元素的序列 （h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1） 
     * (i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）
     * 必为最大项（大顶堆）。完全二 叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
     * 
     * 思想:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对 它们
     * 作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换
     * 位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
     * 
     * 2、杂度：最优O(n)，最差O(nlogn) ，平均接近O(nlogn)
     * 3、不稳定
     * 
     */
    protected void headSort() {
        int[] a = { 27, 49, 78, 34, 12, 64 };
        System.out.println(Arrays.toString(a));
        int arrayLength = a.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始 
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们  
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 交换排序
     */

    /**
     * 冒泡排序
     * 1、基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
     *   让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * 2、杂度：最优O(n)，最差O(n的2次方/2) ，接近O(n的2次方/2) 
     * 3、稳定
     */
    protected void bubblingSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        //冒泡排序
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        this.print(a);
    }

    /**
     * 快速排序
     * 1、基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比
     *   基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *   
     * 2、复杂度：最优O(n)，最差O(nlogn) ，接近O(nlogn) 
     * 3、不稳定
     */
    protected void quickSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };

        quickSort(a, 0, a.length - 1);
        this.print(a);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) { //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while (low < high) {
            //找到比基准元素小的元素位置
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    /**
     * 归并排序 
     * 1、基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列
     * ，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 2、复杂度：最优O(n)，最差O(nlogn) ，接近O(nlogn) 
     * 3、稳定
     */
    protected void mergeSort() {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        mergeSort(a, 0, a.length - 1);

        this.print(a);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            //对左边进行递归
            mergeSort(a, left, middle);
            //对右边进行递归
            mergeSort(a, middle + 1, right);
            //合并
            merge(a, left, middle, right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle + 1; //右边的起始位置
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            //从两个数组中选取较小的数放入中间数组
            if (a[left] <= a[mid]) {
                tmpArr[third++] = a[left++];
            } else {
                tmpArr[third++] = a[mid++];
            }
        }
        //将剩余的部分放入中间数组
        while (left <= middle) {
            tmpArr[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        //将中间数组复制回原数组
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }

    private void print(int[] a) {
        System.out.println("排序之后：");
        System.out.print(Arrays.toString(a));
    }

    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
