package tree

fun main() {
    val tree = makeBeverage()
//    tree.forEachLevelOrder {
//        println(it.value)
//    }
//    tree.search("Black")?.let {
//        println("\nResult: ${it.value}")
//    } ?: println("Not found!")
    tree.printEachLevel()

}

private fun makeBeverage(): TreeNode<String> {
    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")
    val beverage: TreeNode<String> = TreeNode("Beverage").also { treeNode ->
        treeNode.add(hot)
        treeNode.add(cold)
    }

    val tea = TreeNode("Tea")
    val coffee = TreeNode("Coffee")
    val chocolate = TreeNode("Chocolate")

    val blackTea = TreeNode("Black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val milk = TreeNode("milk")
    val soda = TreeNode("soda")

    val gingerAle = TreeNode("ginger Ale")
    val bitterLemon = TreeNode("bitter Lemon")

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return beverage
}

typealias Visitor<T> = (TreeNode<T>) -> Unit

