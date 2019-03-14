给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
fun main(args:Array<String>) {
    val inta = IntArray(5)
    inta[0] = 1
    inta[1] = 2
    inta[2] = 2
    inta[3] = 1
    inta[4] = 5
    print(singleNumber(inta))
}

fun singleNumber(list:IntArray):Int {
    val static = mutableMapOf<Int,Int>()
    list.forEach {
        if(static.containsKey(it)) {
            val newvalue = static.get(it)!!.plus(1)
            static.put(it,newvalue)
        }  else {
            static.put(it,1)
        }
    }
    val keyInter = static.keys.iterator()
    while(keyInter.hasNext()) {
        val key = keyInter.next()
        val value = static.get(key)
        if(value == 1) {
            return key
        }
    }
    return -1
}

fun singleNumer2(list:IntArray):Int {
    val itern = nums.iterator()
    var result = itern.next()
    while(itern.hasNext()) {
        result = result.xor(itern.next())
    }
    return result
}
