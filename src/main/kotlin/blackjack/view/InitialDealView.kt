package blackjack.view

import blackjack.domain.Deck
import blackjack.domain.Member
import blackjack.util.format

private const val INIT_RECEIVED_CARD_COUNT: Int = 2

fun initialize(
    members: List<Member>,
    deck: Deck,
) {
    announce(members)
    dealCardsForAll(members, deck)
}

private fun announce(members: List<Member>) {
    val playerNames: String =
        format(
            members.filter { !it.isDealer() }
                .map { it.name }
                .toList(),
        )

    println("딜러와 $playerNames 에게 $INIT_RECEIVED_CARD_COUNT 장씩 나누었습니다.")
}

private fun dealCardsForAll(
    members: List<Member>,
    deck: Deck,
) {
    for (member in members) {
        dealCardsForSingle(member, deck)
    }
}

private fun dealCardsForSingle(
    member: Member,
    deck: Deck,
) {
    for (i: Int in 1..INIT_RECEIVED_CARD_COUNT) {
        member.receiveCard(deck.draw())
    }
    announce(member)
}

private fun announce(member: Member) {
    if (member.isDealer()) {
        val cardNames = format(member.getCardNames(1))
        println("${member.name} : $cardNames")
        return
    }

    val cardNames = format(member.getCardNames(1))
    println("${member.name} 카드 : $cardNames")
}
