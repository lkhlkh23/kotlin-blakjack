package blackjack.domain

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class DeckTest {
    @Test
    fun `test_drawCard_덱에 카드가 있으면 카드 드로우 가능`() {
        val deck: Deck = Deck()
        assertNotNull(deck.drawCard())
    }

}
