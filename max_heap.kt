package com.company

//最大堆排序

fun main(ars: Array<String>) {
    val list = listOf<Int>(5, 6, 7, 4, 3, 5, 12, 8, 3, 5, 4, 7, 8)
    val heap = heap()
    list.forEach {
        heap.add(it)
    }
    heap.del(4)
    heap.print()
}


class heap {
    val data = mutableListOf(-1)
    var size = data.size - 1

    fun add(num: Int) {
        //add to tail and fix
        size++
        if (size > data.size - 1) {
            data.add(num)
        } else {
            data[size] = num
        }
        var childIndex = size
        while (true) {
            val parentIndex = childIndex.shr(1)
            if (parentIndex < 1) {
                return
            }
            if (data[parentIndex] < data[childIndex]) {
                val temp = data[childIndex]
                data[childIndex] = data[parentIndex]
                data[parentIndex] = temp
            }
            childIndex = parentIndex
        }
    }

    fun del(index: Int) {
        if (index > size || index <= 0) {
            throw ArrayIndexOutOfBoundsException("out of bound of index $index and size $size")
        }
        data[index] = data[size]

        var pIndex = index
        while (true) {
            val childIndex = pIndex.shl(1)
            if (childIndex > size || childIndex < 1) {
                return
            }
            if (childIndex + 1 > size) {
                if (data[pIndex] < data[childIndex]) {
                    val temp = data[childIndex]
                    data[childIndex] = data[pIndex]
                    data[pIndex] = temp
                }
            } else {
                var maxIndex = pIndex
                if (data[pIndex] < data[childIndex]) {
                    maxIndex = childIndex
                }
                if (data[childIndex + 1] > data[maxIndex]) {
                    maxIndex = childIndex + 1
                }
                if (!maxIndex.equals(pIndex)) {
                    val temp = data[maxIndex]
                    data[maxIndex] = data[pIndex]
                    data[pIndex] = temp
                    pIndex = maxIndex
                } else {
                    return
                }
            }

        }
    }

    fun print() {
        data.forEachIndexed { index, i ->
            if (index != 0 && index < size) {
                print("  $i  ")
            }
        }
    }

}





