package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScoreTest {
    @Test
    @DisplayName("점수가 21미만일 경우 true 리턴 (카드 추가 수령 가능)")
    fun `test_canReceiveCard_점수가 21미만일 경우 true 리턴 (카드 추가 수령 가능)`() {
        val score = Score(20)
        assertTrue(score.canReceiveCard())
    }

    @Test
    fun `test_canReceiveCard_점수가 21이상일 경우 false 리턴 (카드 추가 수령 불가)`() {
        val score = Score(21)
        assertFalse(score.canReceiveCard())
    }

    @Test
    fun `test_plusScore_점수 합산`() {
        val score = Score(1)
        score.plusScore(2)

        assertThat(score.score).isEqualTo(3)
    }

    @Test
    fun `test_plusScoreIfLessLimit_점수가 21초과일 경우에는 합산하지 않음`() {
        val score = Score(20)
        score.plusScoreIfLessLimit(2)
        assertThat(score.score).isEqualTo(20)
    }

    @Test
    fun `test_plusScoreIfLessLimit_점수가 21이하일 경우에는 합산함`() {
        val score = Score(20)
        score.plusScoreIfLessLimit(1)
        assertThat(score.score).isEqualTo(21)
    }
}
