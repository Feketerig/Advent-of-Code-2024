fun main() {
    val directions = listOf(
        Pair(-1, -1),
        Pair(-1, 0),
        Pair(0, -1),
        Pair(1, 1),
        Pair(1, 0),
        Pair(0, 1),
        Pair(-1, 1),
        Pair(1, -1),
    )

    fun part1(input: List<String>): Int {
        var count = 0
        for( i in 0..<input.size){
            for( j in 0..<input[i].length){
                if(input.getOrNull(i)?.getOrNull(j) == 'X'){
                    for (dir in directions){
                        if (input.getOrNull(i+dir.first)?.getOrNull(j+dir.second) == 'M' &&
                            input.getOrNull(i+dir.first*2)?.getOrNull(j+dir.second*2) == 'A' &&
                            input.getOrNull(i+dir.first*3)?.getOrNull(j+dir.second*3) == 'S') {
                            count++
                        }
                    }
                }
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for( i in 0..<input.size) {
            for (j in 0..<input[i].length) {
                if (input.getOrNull(i)?.getOrNull(j) == 'A') {
                    val a = input.getOrNull(i-1)?.getOrNull(j-1)
                    val b = input.getOrNull(i-1)?.getOrNull(j+1)
                    val c = input.getOrNull(i+1)?.getOrNull(j-1)
                    val d = input.getOrNull(i+1)?.getOrNull(j+1)
                    if (((a == 'M' && d == 'S') || (a == 'S' && d == 'M')) && ((b == 'M' && c == 'S') || (b == 'S' && c == 'M'))){
                        count++
                    }
                }
            }
        }
        return count
    }



    val testInput = readInput("Day04_test")
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}