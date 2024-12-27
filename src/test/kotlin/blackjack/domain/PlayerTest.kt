package blackjack.domain

import blackjack.domain.type.TrumpCard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    fun `test_canReceiveCard_점수가 21 미만이면 true 리턴 (카드 추가 획득 가능)`() {
        val player = Player("LEE")
        assertTrue(player.canReceiveCard())
    }

    @Test
    fun `test_canReceiveCard_점수가 21 이상이면 false 리턴 (카드 추가 획득 불가)`() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_10)
        player.receiveCard(TrumpCard.HEART_10)
        player.receiveCard(TrumpCard.HEART_2)

        assertFalse(player.canReceiveCard())
    }

    @Test
    fun `test_receiveCard_카드 정상 드로우`() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)

        assertThat(player.cards.size).isEqualTo(1)
        assertThat(player.score.score).isEqualTo(1)
    }

    @Test
    fun `test_getTotalScore_에이스는 21을 초과하지 않는 한에서 점수 계산`() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)
        player.receiveCard(TrumpCard.HEART_2)

        assertThat(player.getTotalScore().score).isEqualTo(13)
    }

    @Test
    fun `test_getCardNames_보유한 전체 카드의 풀네임 리턴 (A클로바, 1하트)`() {
        val player = Player("LEE")
        player.receiveCard(TrumpCard.CLUB_ACE)
        player.receiveCard(TrumpCard.HEART_2)

        assertThat(player.getCardNames()).isEqualTo(listOf("A클로바", "2하트"))
    }
}
