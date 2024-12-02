import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val aIds = mutableListOf<Int>()
        val bIds = mutableListOf<Int>()

        input.forEach { entry ->
            val ids = entry.split("\\s+".toRegex()).map { it.toInt() }
            aIds.add(ids[0])
            bIds.add(ids[1])
        }

        aIds.sort()
        bIds.sort()

        return aIds.foldIndexed(0) { index, acc, id -> acc + abs(bIds[index] - id) }
    }

    fun part2(input: List<String>): Int {
        val aIds = mutableListOf<Int>()
        val occurrencesById = mutableMapOf<Int, Int>()

        input.forEach { entry ->
            val ids = entry.split("\\s+".toRegex()).map { it.toInt() }
            aIds.add(ids[0])
            occurrencesById[ids[1]] = occurrencesById.getOrDefault(ids[1], 0) + 1
        }

        return aIds.fold(0) { acc, id ->
            acc + (id * occurrencesById.getOrDefault(id, 0))
        }
    }

    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    check(part1(testInput) == 11)
    part1(input).println()

    check(part2(testInput) == 31)
    part2(input).println()
}
