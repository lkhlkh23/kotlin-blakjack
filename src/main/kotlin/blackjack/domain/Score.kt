package blackjack.domain

import blackjack.domain.type.TrumpCard

class Score constructor(var score: Int) {
    companion object {
        @JvmStatic
        private val SCORE_LIMIT: Int = 21
    }

    fun canReceiveCard(): Boolean {
        return this.score < SCORE_LIMIT
    }

    fun addNumber(card: TrumpCard) {
        this.score = card.addNumber(this.score)
    }

    fun addNumberAndBonus(card: TrumpCard) {
        this.score = card.addNumberAndBonus(this.score)
    }

    fun subtractBonusIfOverLimit(card: TrumpCard) {
        if (this.score > SCORE_LIMIT) {
            this.score = card.subtractBonus(this.score)
        }
    }
}
