package blackjack.domain

import blackjack.domain.type.TrumpCard

class Player constructor(val name: String, val cards: ArrayList<TrumpCard>, val score: Score) {
    fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard()
    }

    fun receiveCard(card: TrumpCard) {
        this.cards.add(card)
        this.score.addNumber(card)
    }

    fun getTotalScore(): Int {
        return TrumpCard.getTotalScore(this.cards)
    }

    fun getCardNames(): List<String> {
        return this.cards.stream()
            .map { card -> card.getName() }
            .toList()
    }
}
