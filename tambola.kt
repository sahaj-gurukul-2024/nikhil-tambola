fun main() {
  val board = listOf(setOf(), setOf(), setOf())
  val announcements = listOf()
  val claim = ""

  result = isValidClaim(board, announcements, claim)
}

fun isValidClaim(board: List<Set<Int>>, announcements: List<Int>, claim: String): Boolean {
  var topMatches = 0
  var bottomMatches = 0
  var overallMatches = 0

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
  
}
