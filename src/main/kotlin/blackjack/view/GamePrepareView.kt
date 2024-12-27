package blackjack.view

import blackjack.domain.Deck
import blackjack.domain.Player

class GamePrepareView {
    companion object {
        @JvmStatic
        private val INIT_RECEIVED_CARD_COUNT: Int = 2

        @JvmStatic
        fun prepare(
            players: List<Player>,
            deck: Deck,
        ) {
            dealAnnounce(players)
            dealCardsToAll(players, deck)
        }

        @JvmStatic
        private fun dealAnnounce(players: List<Player>) {
            val playerNames: String = players.joinToString(", ") { it.name }
            println("$playerNames 에게 $INIT_RECEIVED_CARD_COUNT 장씩 나누었습니다.")
        }

        @JvmStatic
        private fun dealCardsToAll(
            players: List<Player>,
            deck: Deck,
        ) {
            for (player in players) {
                dealCardsToSingle(player, deck)
            }
        }

        @JvmStatic
        private fun dealCardsToSingle(
            player: Player,
            deck: Deck,
        ) {
            for (i: Int in 1..INIT_RECEIVED_CARD_COUNT) {
                player.receiveCard(deck.drawCard())
            }

            println("${player.name} 카드 : ${player.cards[0].getFullName()}, ${player.cards[1].getFullName()}")
        }
    }
}
