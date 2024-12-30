package blackjack.controller

import blackjack.domain.Dealer
import blackjack.domain.Deck
import blackjack.domain.Member
import blackjack.view.DealerGameView
import blackjack.view.PlayerGameView
import blackjack.view.getPlayers
import blackjack.view.initialize
import blackjack.view.showScoreForAll

fun run() {
    val players: List<Member> = getPlayers()
    val dealer: Member = Dealer()
    val members: List<Member> = players + dealer
    val deck: Deck = Deck()

    initialize(members, deck)
    DealerGameView.play(dealer, deck)
    PlayerGameView.play(members, deck)
    showScoreForAll(members)
}

fun main() {
    run()
}
