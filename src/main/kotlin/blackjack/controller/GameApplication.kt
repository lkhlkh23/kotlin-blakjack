package blackjack.controller

import blackjack.domain.Deck
import blackjack.domain.Player
import blackjack.view.getPlayers
import blackjack.view.playTurnsForAll
import blackjack.view.prepare
import blackjack.view.showScoreForAll

fun run() {
    val players: List<Player> = getPlayers()
    val deck: Deck = Deck()

    prepare(players, deck)
    playTurnsForAll(players, deck)
    showScoreForAll(players)
}

fun main() {
    run()
}
