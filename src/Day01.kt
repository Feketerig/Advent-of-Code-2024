import kotlin.math.abs

fun main() {
    fun createLists(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()
        input.forEach {
            firstList.add(it.split("   ")[0].toInt())
            secondList.add(it.split("   ")[1].toInt())
        }
        return Pair(firstList, secondList)
    }

    fun part1(input: List<String>): Int {
        val (firstList, secondList) = createLists(input)
        firstList.sort()
        secondList.sort()
        return firstList.zip(secondList).sumOf { pair ->
            abs(pair.first - pair.second)
        }
    }

    fun part2(input: List<String>): Int {
        val (firstList, secondList) = createLists(input)
        return firstList.sumOf { number ->
            secondList.count { number == it } * number
        }
    }



    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
