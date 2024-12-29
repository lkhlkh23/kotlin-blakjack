package blackjack.domain

import blackjack.domain.type.TrumpCard
import java.util.LinkedList
import java.util.Queue

class Deck {
    private val cards: Queue<TrumpCard> = LinkedList(TrumpCard.entries.shuffled())

    fun draw(): TrumpCard {
        return this.cards.poll()
    }
}
