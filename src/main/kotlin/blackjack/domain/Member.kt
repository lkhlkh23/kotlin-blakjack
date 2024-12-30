package blackjack.domain

import blackjack.domain.type.TrumpCard

abstract class Member(val name: String, val cards: ArrayList<TrumpCard> = ArrayList(), var score: Score = Score.from(0)) {
    fun receiveCard(card: TrumpCard) {
        this.cards.add(card)
        this.score = card.plusBaseValue(score)
    }

    fun getTotalScore(): Score {
        return TrumpCard.getTotalScore(this.cards, this.score)
    }

    fun getCardNames(): List<String> {
        return this.cards.stream()
            .map { card -> card.getFullName() }
            .toList()
    }

    abstract fun canReceiveCard(): Boolean

    abstract fun isDealer(): Boolean
}
