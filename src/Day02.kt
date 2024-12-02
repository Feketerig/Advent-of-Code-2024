fun main() {
    fun createReports(input: List<String>): List<List<Int>> {
        return input.map { line ->
            line.split(" ").map(String::toInt)
        }
    }

    fun List<Int>.isSafe(): Boolean {
        val inc = zipWithNext().all { (first, second) ->
            (first > second && 1 <= first - second && first - second <= 3)
        }
        val dec = zipWithNext().all { (first, second) ->
            (second > first && 1 <= second - first && second - first <= 3)
        }
        return inc || dec
    }

    fun part1(input: List<String>): Int {
        val reports = createReports(input)
        return reports.count {
            it.isSafe()
        }
    }

    fun part2(input: List<String>): Int {
        val reports = createReports(input)
        return reports.count { report ->
            report.isSafe() ||
            report.indices.any {
                report.toMutableList().apply { removeAt(it) }.isSafe()
            }
        }
    }



    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}