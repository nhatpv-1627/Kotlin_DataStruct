package queue

import stack.StackImp

class DoubleStack<T> : Queue<T> {

    private val leftStack = StackImp<T>()
    private val rightStack = StackImp<T>()

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty) transferElements()
        return leftStack.pop()
    }

    override val count: Int
        get() = rightStack.count

    override fun peek(): T? {
        if (leftStack.isEmpty) transferElements()
        return leftStack.peek()
    }

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }
}
