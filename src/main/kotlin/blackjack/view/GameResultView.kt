package blackjack.view

import blackjack.domain.Member

fun showScores(players: List<Member>) {
    for (player in players) {
        val cards: String = player.getCardNames().joinToString(",")
        val score: Int = player.getTotalScore().score
        println("${player.name} 카드 : $cards - 결과 : $score")
    }
}

fun showRecords(players: List<Member>) {
    println("## 최종 승페")
    for (player in players) {
        println("${player.name} : ${player.getRecord(players)}")
    }
}
