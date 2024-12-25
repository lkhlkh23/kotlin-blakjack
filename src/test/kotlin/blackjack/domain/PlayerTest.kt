package blackjack.domain

import blackjack.domain.type.TrumpCard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    @DisplayName("점수가 21 미만이면 true 리턴 (카드 추가 획득 가능)")
    fun test_canReceiveCard_1() {
        val player = Player("LEE")
        assertTrue(player.canReceiveCard())
    }

    @Test
    @DisplayName("점수가 21 이상이면 false 리턴 (카드 추가 획득 불가)")
    fun test_canReceiveCard_2() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_10)
        player.receiveCard(TrumpCard.HEART_10)
        player.receiveCard(TrumpCard.HEART_1)

        assertFalse(player.canReceiveCard())
    }

    @Test
    @DisplayName("카드 정상 드로우")
    fun test_receiveCard_1() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)

        assertThat(player.cards.size).isEqualTo(1)
        assertThat(player.score.score).isEqualTo(1)
    }

    @Test
    @DisplayName("에이스는 21을 초과하지 않는 한에서 점수 계산")
    fun test_getTotalScore() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)
        player.receiveCard(TrumpCard.HEART_1)

        assertThat(player.getTotalScore().score).isEqualTo(12)
    }

    @Test
    @DisplayName("보유한 전체 카드의 풀네임 리턴 (A클로바, 1하트)")
    fun test_getCardNames() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)
        player.receiveCard(TrumpCard.HEART_1)

        assertThat(player.getCardNames()).isEqualTo(listOf("A클로바", "1하트"))
    }
}
