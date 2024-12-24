package blackjack.view

import blackjack.domain.Player

class GameResultView {
    companion object {
        @JvmStatic
        fun showPlayerScores(players: List<Player>) {
            for (player in players) {
                showPlayerScore(player)
            }
        }

        private fun showPlayerScore(player: Player) {
            val cards: String = player.getCardNames().joinToString(",")
            val score: Int = player.getTotalScore()
            println("${player.name} 카드 : $cards - 결과 : $score")
        }
    }
}
