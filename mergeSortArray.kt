 /**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

 */

fun main(args: Array<String>) {
    val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
    val nums2 = intArrayOf(1, 2, 3)
    merge(nums1, 3, nums2, 3)
    nums1.forEach {
        print(it)
    }
}


fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    //从后往前排
    var index1 = m - 1
    var index2 = n - 1
    var indexTotal = m + n - 1
    while (true) {
        if (index2 < 0) {
            return
        }
        if (index1 < 0) {
            nums1[indexTotal] = nums2[index2]
            indexTotal--
            index2--
            continue
        }
        if (nums1[index1] < nums2[index2]) {
            nums1[indexTotal] = nums2[index2]
            indexTotal--
            index2--
        } else {
            nums1[indexTotal] = nums1[index1]
            index1--
            indexTotal--
        }
    }

}
