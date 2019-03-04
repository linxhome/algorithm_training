//用链表表示大数，如何进行加法运算

class Node(var data: Int = 0, var next: Node? = null)

fun addNode(leftNode: Node, rightNode: Node) {
    val leftSize = getNodeSize(leftNode)
    val rightSize = getNodeSize(rightNode)

    var leftStartNode: Node? = null
    var rightStartNode: Node? = null

    var retStartNode: Node? = null
    var retEndNode: Node? = null

    if (leftSize > rightSize) {
        leftStartNode = findNode(leftNode, abs(leftSize - rightSize) + 1)
        rightStartNode = rightNode

        retStartNode = cpNode(leftNode, abs(leftSize - rightSize))
    } else if (rightSize > leftSize) {
        rightStartNode = findNode(rightNode, abs(leftSize - rightSize) + 1)
        leftStartNode = leftNode
        retStartNode = cpNode(rightNode, abs(leftSize - rightSize))
    } else {
        leftStartNode = leftNode
        rightStartNode = rightNode
    }
    retEndNode = if (retStartNode == null) null else getEndNode(retStartNode)
    var plusNode: Node? = null

    //construct the data
    do {
        var plusRet = leftStartNode!!.data + rightStartNode!!.data
        if (plusRet > 9) {
            if (retEndNode == null) {
                retEndNode = Node(1, null)
                if (retStartNode == null) {
                    retStartNode = retEndNode
                }
                retEndNode.next = Node(plusRet - 10, null)
                retEndNode = retEndNode.next
            } else {
                retEndNode.next = Node(plusRet - 10, null)
                retEndNode = retEndNode.next
                pluslevel(plusNode, retEndNode!!)
            }
            plusNode = retEndNode
        } else {
            if (retEndNode != null) {
                retEndNode.next = Node(plusRet, null)
                retEndNode = retEndNode.next
            } else {
                retStartNode = Node(plusRet, null)
                retEndNode = retStartNode
            }
            if (plusRet < 9) {
                plusNode = retEndNode
            }
        }
        leftStartNode = leftStartNode.next
        rightStartNode = rightStartNode.next
    } while (leftStartNode != null && rightStartNode != null)
    printNode(retStartNode!!)
}

fun pluslevel(plusNode: Node?, endNode: Node) {
    plusNode?.let {
        it.data += 1
        var temp: Node? = it.next
        while (temp != null && temp != endNode) {
            temp.data = 0
            temp = temp.next
        }
    }
}

fun cpNode(node: Node, position: Int): Node? {
    var newNodeStart = Node(node.data, null)
    var indexNode = node
    var indexNewNode = newNodeStart
    var indexNew = 1

    while (indexNode.next != null && indexNew < position) {
        indexNode = indexNode.next!!
        val newNode = Node(indexNode.data, null)
        indexNewNode.next = newNode
        indexNewNode = newNode
        indexNew++
    }
    return newNodeStart
}

fun getEndNode(node: Node): Node {
    var temp: Node = node
    while (temp.next != null) {
        temp = temp.next!!
    }
    return temp
}

fun findNode(node: Node, position: Int): Node? {
    var index = position
    var temp: Node? = node
    while (index > 1 && temp?.next != null) {
        index--
        temp = temp.next
    }
    return temp
}


fun getNodeSize(node: Node): Int {
    var size = 1
    var temp = node.next
    while (temp != null) {
        temp = temp.next
        size++
    }
    return size
}

fun printNode(node: Node) {
    var temp: Node? = node
    while (temp != null) {
        print(temp.data)
        temp = temp.next
    }
}

