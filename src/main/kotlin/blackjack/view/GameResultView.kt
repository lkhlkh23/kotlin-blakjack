package blackjack.view

import blackjack.domain.Player

fun showScoreForAll(players: List<Player>) {
    for (player in players) {
        showScoreForSingle(player)
    }
}

private fun showScoreForSingle(player: Player) {
    val cards: String = player.getCardNames().joinToString(",")
    val score: Int = player.getTotalScore().score
    println("${player.name} 카드 : $cards - 결과 : $score")
}
