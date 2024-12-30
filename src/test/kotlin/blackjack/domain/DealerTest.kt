package blackjack.domain

import blackjack.domain.type.TrumpCard
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class DealerTest {

    @Test
    fun `test_canReceiveCard_16을 넘지 않고 3장 카드 드로우 가능`() {
        val dealer : Dealer = Dealer()
        assertTrue(dealer.canReceiveCard())
    }

    @Test
    fun `test_canReceiveCard_16을 넘으면 드로우 불가`() {
        val dealer : Dealer = Dealer()
        dealer.receiveCard(TrumpCard.CLUB_10)
        dealer.receiveCard(TrumpCard.HEART_10)
        assertFalse(dealer.canReceiveCard())
    }
}