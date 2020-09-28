package stack

import linked_list.LinkedList

fun <T> LinkedList<T>.printReverse() {
    val stack = StackImp<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}

fun String.checkParentheses(): Boolean {
    val stack = StackImp<Char>()
    for (c in this) {
        when (c) {
            '(' -> stack.push(c)
            ')' -> if (stack.isEmpty) return false else stack.pop()
        }
    }
    return stack.isEmpty
}
