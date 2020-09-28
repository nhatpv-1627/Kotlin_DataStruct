package binary_tree


typealias Visitor<T> = (T?) -> Unit

fun main() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    val eleven = BinaryNode(11)
    val twelve = BinaryNode(12)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five

    seven.rightChild = nine
    nine.leftChild = eight
    five.leftChild = eleven
    eleven.rightChild = twelve

//    val tree = seven
//    println(seven)
//    seven.travelInOrder {
//        println(it)
//    }
    println(seven)
    println("height= " + seven.height())
    val array = seven.serialize()
    println("serialize= $array")
    println("deserialize= " + seven.deserializeOptimized(array))


}

