fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            """mul\((\d+),(\d+)\)""".toRegex().findAll(it).sumOf {
                val (_, first, second) = it.groupValues
                first.toInt() * second.toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        var enabled = true
        return input.sumOf {
            """mul\((\d+),(\d+)\)|do\(\)|don't\(\)""".toRegex().findAll(it).sumOf {
                val (string, first, second) = it.groupValues
                when(string) {
                    "do()" -> {
                        enabled = true
                        0
                    }
                    "don't()" -> {
                        enabled = false
                        0
                    }
                    else -> if (enabled)first.toInt() * second.toInt() else 0
                }
            }
        }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}