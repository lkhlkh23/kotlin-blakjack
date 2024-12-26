package blackjack.domain

import blackjack.domain.type.TrumpCard
import java.util.LinkedList
import java.util.Queue

class Deck {
    private val cards: Queue<TrumpCard> = LinkedList()

    init {
        for (card in cards) {
            this.cards.add(card)
        }
    }

    fun drawCard(): TrumpCard {
        return this.cards.poll()
    }
}
