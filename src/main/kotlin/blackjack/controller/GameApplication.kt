package blackjack.controller

import blackjack.domain.Dealer
import blackjack.domain.Player
import blackjack.view.GameAttendanceView
import blackjack.view.GameBoardView
import blackjack.view.GamePrepareView
import blackjack.view.GameResultView

class GameApplication {
    fun run() {
        val players: List<Player> = GameAttendanceView.getPlayers()
        val dealer: Dealer = Dealer()
        GamePrepareView.dealCards(players, dealer)
        for (player in players) {
            GameBoardView.play(player, dealer)
        }
        GameResultView.showPlayerScores(players);
    }
}

fun main() {
    GameApplication().run()
}
