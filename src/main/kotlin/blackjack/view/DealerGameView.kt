package blackjack.view

import blackjack.domain.Deck
import blackjack.domain.Member
import blackjack.domain.type.MemberType

object DealerGameView {
    fun play(
        dealer: Member,
        deck: Deck,
    ) {
        if (dealer.canReceiveCard()) {
            dealer.receiveCard(deck.draw())
            println("${dealer.name}  ${MemberType.DEALER.drawableLimit} 이하라 한장의 카드를 더 받았습니다.")
        }
    }
}
