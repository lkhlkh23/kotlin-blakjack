package blackjack.domain.type

import blackjack.domain.Score

enum class TrumpCard constructor(val shape: TrumpCardShape, val letter: String, val number: Int, val bonus: Int) {
    HEART_1(TrumpCardShape.HEART, "1", 1, 0),
    HEART_2(TrumpCardShape.HEART, "2", 2, 0),
    HEART_3(TrumpCardShape.HEART, "3", 3, 0),
    HEART_4(TrumpCardShape.HEART, "4", 4, 0),
    HEART_5(TrumpCardShape.HEART, "5", 5, 0),
    HEART_6(TrumpCardShape.HEART, "6", 6, 0),
    HEART_7(TrumpCardShape.HEART, "7", 7, 0),
    HEART_8(TrumpCardShape.HEART, "8", 8, 0),
    HEART_9(TrumpCardShape.HEART, "9", 9, 0),
    HEART_10(TrumpCardShape.HEART, "10", 10, 0),
    HEART_ACE(TrumpCardShape.HEART, "A", 1, 10),
    HEART_QUEEN(TrumpCardShape.HEART, "Q", 10, 0),
    HEART_JACK(TrumpCardShape.HEART, "J", 10, 0),
    HEART_KING(TrumpCardShape.HEART, "K", 10, 0),
    DIAMOND_1(TrumpCardShape.DIAMOND, "1", 1, 0),
    DIAMOND_2(TrumpCardShape.DIAMOND, "2", 2, 0),
    DIAMOND_3(TrumpCardShape.DIAMOND, "3", 3, 0),
    DIAMOND_4(TrumpCardShape.DIAMOND, "4", 4, 0),
    DIAMOND_5(TrumpCardShape.DIAMOND, "5", 5, 0),
    DIAMOND_6(TrumpCardShape.DIAMOND, "6", 6, 0),
    DIAMOND_7(TrumpCardShape.DIAMOND, "7", 7, 0),
    DIAMOND_8(TrumpCardShape.DIAMOND, "8", 8, 0),
    DIAMOND_9(TrumpCardShape.DIAMOND, "9", 9, 0),
    DIAMOND_10(TrumpCardShape.DIAMOND, "10", 10, 0),
    DIAMOND_ACE(TrumpCardShape.DIAMOND, "A", 1, 10),
    DIAMOND_QUEEN(TrumpCardShape.DIAMOND, "Q", 10, 0),
    DIAMOND_JACK(TrumpCardShape.DIAMOND, "J", 10, 0),
    DIAMOND_KING(TrumpCardShape.DIAMOND, "K", 10, 0),
    SPADE_1(TrumpCardShape.SPADE, "1", 1, 0),
    SPADE_2(TrumpCardShape.SPADE, "2", 2, 0),
    SPADE_3(TrumpCardShape.SPADE, "3", 3, 0),
    SPADE_4(TrumpCardShape.SPADE, "4", 4, 0),
    SPADE_5(TrumpCardShape.SPADE, "5", 5, 0),
    SPADE_6(TrumpCardShape.SPADE, "6", 6, 0),
    SPADE_7(TrumpCardShape.SPADE, "7", 7, 0),
    SPADE_8(TrumpCardShape.SPADE, "8", 8, 0),
    SPADE_9(TrumpCardShape.SPADE, "9", 9, 0),
    SPADE_10(TrumpCardShape.SPADE, "10", 10, 0),
    SPADE_ACE(TrumpCardShape.SPADE, "A", 1, 10),
    SPADE_QUEEN(TrumpCardShape.SPADE, "Q", 10, 0),
    SPADE_JACK(TrumpCardShape.SPADE, "J", 10, 0),
    SPADE_KING(TrumpCardShape.SPADE, "K", 10, 0),
    CLUB_1(TrumpCardShape.CLUB, "1", 1, 0),
    CLUB_2(TrumpCardShape.CLUB, "2", 2, 0),
    CLUB_3(TrumpCardShape.CLUB, "3", 3, 0),
    CLUB_4(TrumpCardShape.CLUB, "4", 4, 0),
    CLUB_5(TrumpCardShape.CLUB, "5", 5, 0),
    CLUB_6(TrumpCardShape.CLUB, "6", 6, 0),
    CLUB_7(TrumpCardShape.CLUB, "7", 7, 0),
    CLUB_8(TrumpCardShape.CLUB, "8", 8, 0),
    CLUB_9(TrumpCardShape.CLUB, "9", 9, 0),
    CLUB_10(TrumpCardShape.CLUB, "10", 10, 0),
    CLUB_ACE(TrumpCardShape.CLUB, "A", 1, 10),
    CLUB_QUEEN(TrumpCardShape.CLUB, "Q", 10, 0),
    CLUB_JACK(TrumpCardShape.CLUB, "J", 10, 0),
    CLUB_KING(TrumpCardShape.CLUB, "K", 10, 0),
    ;

    companion object {
        @JvmStatic
        fun getTotalScore(cards: List<TrumpCard>): Int {
            val score = Score(0)
            for (card in cards) {
                score.addNumberAndBonus(card)
            }

            for (card in cards) {
                score.subtractBonusIfOverLimit(card)
            }

            return score.score
        }
    }

    fun addNumber(score: Int): Int {
        return this.number + score
    }

    fun addNumberAndBonus(score: Int): Int {
        return this.number + this.bonus + score
    }

    fun subtractBonus(score: Int): Int {
        return score - this.bonus
    }

    fun getName(): String {
        return this.letter + this.shape.name
    }
}
