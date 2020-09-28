package linked_list

fun <T : Comparable<T>> LinkedList<T>.mergerSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()
    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value)
            left = linked_list.appendNote(result, left)
        else
            right = linked_list.appendNote(result, right)
    }

    while (left != null) {
        left = linked_list.appendNote(result, left)
    }
    while (right != null) {
        right = linked_list.appendNote(result, right)
    }
    return result
}

fun <T : Comparable<T>> appendNote(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}

fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    //1
    val next = node.next
    if (next != null) {
        //2
        addInReverse(list, next)
    }
    //3
    list.append(node.value)
}

fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) linked_list.addInReverse(result, head)
    return result
}

fun <T> LinkedList<T>.printMiddleElement() {
    println(this)
    println("middle is " + nodeAt(this.size / 2)?.value)
}

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var fast = this.nodeAt(0)
    var slow = this.nodeAt(0)

    while (fast?.next != null) {
        fast = fast.next
        if (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
    }

    return slow
}

fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) print(" -> ")
    print(this.value.toString())
}