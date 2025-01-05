package blackjack.domain

import blackjack.domain.type.MemberType
import blackjack.domain.type.TrumpCard
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DealerTest {
    @Test
    fun `test_canReceiveCard_16을 넘지 않고 3장 카드 드로우 가능`() {
        val dealer = Member("딜러", MemberType.DEALER)
        assertTrue(dealer.canReceiveCard())
    }

    @Test
    fun `test_canReceiveCard_16을 넘으면 드로우 불가`() {
        val dealer = Member("딜러", MemberType.DEALER)
        dealer.receiveCard(TrumpCard.CLUB_10)
        dealer.receiveCard(TrumpCard.HEART_10)
        assertFalse(dealer.canReceiveCard())
    }
}
