package queue

fun main() {
    val queue = ArrayListQueue<String>().apply {
        enqueue("Nhat")
        enqueue("Hieu")
        enqueue("Phuong")
        enqueue("Minh")
    }
    println(queue)
//    println("===== boardgame =======")
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
//    queue.nextPlayer()
//    println(queue)
    queue.reverse()
    println(queue)

}
