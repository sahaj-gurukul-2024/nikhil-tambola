fun main() {
    val board = listOf(setOf(4, 16, 48, 63, 76), setOf(7, 23, 38, 52, 80), setOf(9, 25, 56, 64, 83))
    val announcements = listOf(90, 4, 46, 63, 89, 16, 76, 48)
    val claim = "top"

    val result = isValidClaim(board, announcements, claim)

    if (result) {
        println("Accepted")
    } else {
        println("Rejected")
    }
}

fun isValidClaim(board: List<Set<Int>>, announcements: List<Int>, claim: String): Boolean {
    var topMatches = 0
    var bottomMatches = 0
    var overallMatches = 0

    if (announcements.size < 5) {
        return false
    }

    for (i in 0..announcements.size-2) {
        if (announcements[i] in board[0]) {
            topMatches += 1
            overallMatches += 1
        }
        if (announcements[i] in board[1]) {
            overallMatches += 1
        }
        if (announcements[i] in board[2]) {
            bottomMatches += 1
            overallMatches += 1
        }
    }

    val last = announcements[announcements.size-1]
    if (claim == "top") {
        return topMatches == 4 && (last in board[0])
    }
    if (claim == "bottom") {
        return bottomMatches == 4 && (last in board[2])
    }
    if (claim == "first") {
        return overallMatches == 4 && (last in board[0] || last in board[1] || last in board[2])
    }
    return false
}
