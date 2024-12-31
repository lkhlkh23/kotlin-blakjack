package blackjack.controller

import blackjack.domain.Deck
import blackjack.domain.Member
import blackjack.domain.type.MemberType
import blackjack.view.DealerGameView
import blackjack.view.PlayerGameView
import blackjack.view.getPlayers
import blackjack.view.initialize
import blackjack.view.showScoreForAll

fun run() {
    val players: List<Member> = getPlayers()
    val dealer = Member("딜러", MemberType.DEALER)
    val members: List<Member> = players + dealer
    val deck: Deck = Deck()

    initialize(members, deck)
    DealerGameView.play(dealer, deck)
    PlayerGameView.play(players, deck)
    showScoreForAll(members)
}

fun main() {
    run()
}
