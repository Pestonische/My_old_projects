const val ITERATIONS = 8
const val test = 4
const val KEY = 788803241


fun main() {
    val system = Hash()
    println("Hash : ${String(system.getHash("file1.txt"))}")
    println("Hash : ${String(system.getHash("file2.txt"))}")
}

