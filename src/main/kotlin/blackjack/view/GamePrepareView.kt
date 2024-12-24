package blackjack.view

import blackjack.domain.Dealer
import blackjack.domain.Player

class GamePrepareView {
    companion object {
        @JvmStatic
        private val INIT_RECEIVED_CARD_COUNT: Int = 2

        @JvmStatic
        fun dealCards(
            players: List<Player>,
            dealer: Dealer,
        ) {
            dealAnnounce(players)
            dealCardsToPlayers(players, dealer)
        }

        @JvmStatic
        private fun dealAnnounce(players: List<Player>) {
            val playerNames: String = players.joinToString(", ") { it.name }
            println("$playerNames 에게 $INIT_RECEIVED_CARD_COUNT 장씩 나누었습니다.")
        }

        @JvmStatic
        private fun dealCardsToPlayers(
            players: List<Player>,
            dealer: Dealer,
        ) {
            for (player in players) {
                dealCardsToPlayer(player, dealer)
            }
        }

        @JvmStatic
        private fun dealCardsToPlayer(
            player: Player,
            dealer: Dealer,
        ) {
            for (i: Int in 1..INIT_RECEIVED_CARD_COUNT) {
                player.receiveCard(dealer.drawCard())
            }

            println("${player.name} 카드 : ${player.cards[0]}, ${player.cards[1]}")
        }
    }
}
