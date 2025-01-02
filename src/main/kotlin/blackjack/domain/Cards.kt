package blackjack.domain

import blackjack.domain.type.TrumpCard

class Cards(private val cards: MutableList<TrumpCard> = ArrayList()) {

    fun add(card: TrumpCard) {
        this.cards.add(card)
    }

    fun getTotalScore(score: Score): Score {
        return TrumpCard.getTotalScore(this.cards, score)
    }

    fun getCardNames(): List<String> {
        return this.cards.stream()
            .map { card -> card.getFullName() }
            .toList()
    }
}