fun main(args: Array<String>) {
    val cal = Fabbonaci()
    //println("10= ${cal.calculateFab(500)}")
    println("1000= ${cal.calculateFab2(20)}")
}

class Fabbonaci {

    val tempArr: IntArray = IntArray(10000, { -1 })

    fun calculateFab(n: Int): Int {
        if (n < 0) {
            throw RuntimeException("fu shu")
        }
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (tempArr[n] != -1) {
            return tempArr[n]
        } else {
            return calculateFab(n - 1) + calculateFab(n - 2)
        }
    }


    fun calculateFab2(n: Int): Long {
        if (n < 0) {
            throw RuntimeException("fu shu")
        }
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        var index = 2
        val result = LongArray(n)
        result[0] = 0
        result[1] = 1
        while (index < n) {
            result[index] = result[index - 1] + result[index - 2]
            index++
        }
        return result[n - 1] + result[n - 2]
    }
}
