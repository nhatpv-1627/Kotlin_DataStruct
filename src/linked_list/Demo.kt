package linked_list

fun main() {
    val list = LinkedList<Int>()
    list.apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }

    val list2 = LinkedList<Int>().apply {
        add(15)
        add(2)
        add(40)
        add(8)
        add(10)
    }
    println(list)
    println(list2)
    println(list.mergerSorted(list2))

    //println(list.linked_list.getMiddle()?.value.toString())

    // println("before: $list")
    //list.retainAll(list2)
    // println("after: $list")

//    println("before: $list")
//    val note = list.nodeAt(1)
//    list.removeAfter(note!!)
//    println("after: $list")


    //val middleNode = list.nodeAt(1)!!
    //list.insert(-1, middleNode)
    //println("After inserting: $list")
}
