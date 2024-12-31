package blackjack.controller

import blackjack.domain.Deck
import blackjack.domain.Member
import blackjack.domain.type.MemberType
import blackjack.view.*

fun run() {
    val players: List<Member> = getPlayers()
    val dealer = Member("딜러", MemberType.DEALER)
    val members: List<Member> = players + dealer
    val deck: Deck = Deck()

    initialize(members, deck)
    DealerGameView.play(dealer, deck)
    PlayerGameView.play(players, deck)
    showScores(members)
    showRecords(members)
}

fun main() {
    run()
}
