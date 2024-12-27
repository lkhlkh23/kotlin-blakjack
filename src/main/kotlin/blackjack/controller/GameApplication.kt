package blackjack.controller

import blackjack.domain.Deck
import blackjack.domain.Player
import blackjack.view.GameAttendanceView
import blackjack.view.GamePlayView
import blackjack.view.GamePrepareView
import blackjack.view.GameResultView

class GameApplication {
    fun run() {
        val players: List<Player> = GameAttendanceView.getPlayers()
        val deck: Deck = Deck()

        GamePrepareView.prepare(players, deck)
        GamePlayView.playTurnsForAll(players, deck)
        GameResultView.showScoreForAll(players)
    }
}

fun main() {
    GameApplication().run()
}
