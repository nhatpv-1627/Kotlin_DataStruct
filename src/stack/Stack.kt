package stack

interface Stack<Element> {
    fun peek(): Element?
    val count: Int
        get

    fun push(element: Element)

    fun pop(): Element?
}
