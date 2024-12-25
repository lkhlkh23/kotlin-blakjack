package blackjack.domain

import blackjack.domain.type.TrumpCard
import java.util.LinkedList
import java.util.Queue

class Deck {
    private var cards: Queue<TrumpCard> = LinkedList()

    init {
        this.cards = LinkedList(TrumpCard.entries.shuffled())
    }

    fun drawCard(): TrumpCard {
        return this.cards.poll()
    }
}
