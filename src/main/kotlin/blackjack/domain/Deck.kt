package blackjack.domain

import blackjack.domain.type.TrumpCard
import java.util.*

class Deck {
    private val cards: Queue<TrumpCard> = LinkedList(TrumpCard.entries.shuffled())

    fun draw(): TrumpCard {
        if (cards.isEmpty()) {
            throw Exception()
        }

        return this.cards.poll()
    }
}
