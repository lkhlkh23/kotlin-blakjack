package blackjack.domain.type

import blackjack.domain.Score
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TrumpCardTest {
    @Test
    fun test_plusBaseValue() {
        val score = Score(10)
        TrumpCard.CLUB_KING.plusBaseValue(score)
        assertThat(score.score).isEqualTo(20)
    }

    @Test
    @DisplayName("카드 이름 리턴 (예 : 3클로바)")
    fun test_getFullName() {
        assertThat(TrumpCard.CLUB_KING.getFullName()).isEqualTo("K클로바")
    }

    @Test
    @DisplayName("총 점수는 21 초과하지 않도록 리턴")
    fun test_getTotalScore_1() {
        val score = Score(11)
        val cards: List<TrumpCard> = listOf(TrumpCard.CLUB_ACE, TrumpCard.SPADE_ACE, TrumpCard.DIAMOND_ACE, TrumpCard.HEART_ACE)
        assertThat(TrumpCard.getTotalScore(cards, score).score).isEqualTo(21)
    }

    @Test
    @DisplayName("총 점수는 21 초과하지 않도록 리턴")
    fun test_getTotalScore_2() {
        val score = Score(12)
        val cards: List<TrumpCard> = listOf(TrumpCard.CLUB_ACE, TrumpCard.SPADE_ACE, TrumpCard.DIAMOND_ACE, TrumpCard.HEART_ACE)
        assertThat(TrumpCard.getTotalScore(cards, score).score).isEqualTo(12)
    }
}
