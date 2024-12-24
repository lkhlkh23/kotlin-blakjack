package blackjack.domain

import blackjack.domain.type.TrumpCard
import java.util.LinkedList
import java.util.Queue

class Dealer {
    // 카드 보유
    private var cards: Queue<TrumpCard> = LinkedList()

    init {
        this.cards = LinkedList(TrumpCard.entries.shuffled())
    }

    fun drawCard(): TrumpCard {
        return this.cards.poll()
    }
}
