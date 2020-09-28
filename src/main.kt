fun main() {
    var a = needForceUpdate("3.0.0(9)","3.0.1(2)")
    print(a)
}

private fun needForceUpdate(
    currentVersion: String,
    serverVersion: String
): Boolean {
    val currentVersionItems = splitVersionText(currentVersion)
    val serverVersionItems = splitVersionText(serverVersion)
    if (currentVersionItems.size != serverVersionItems.size) return false

    for (i in 0 until currentVersionItems.size) {
        return if (currentVersionItems[i] < serverVersionItems[i]) true
        else if (currentVersionItems[i] > serverVersionItems[i]) false
        else continue
    }

    return false
}

private fun splitVersionText(current: String): MutableList<Int> {
    var string = ""
    val result = mutableListOf<Int>()
    current.forEach {
        if (".()".contains(it)) {
            result.add(
                try {
                    string.toInt()
                } catch (e: Exception) {
                    0
                }
            )
            string = ""
        } else {
            string += it
        }
    }

    return result
}