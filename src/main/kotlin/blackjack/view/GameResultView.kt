package blackjack.view

import blackjack.domain.Member

fun showScoreForAll(players: List<Member>) {
    for (player in players) {
        showScoreForSingle(player)
    }
}

private fun showScoreForSingle(player: Member) {
    val cards: String = player.getCardNames().joinToString(",")
    val score: Int = player.getTotalScore().score
    println("${player.name} 카드 : $cards - 결과 : $score")
}
