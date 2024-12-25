package blackjack.view

import blackjack.domain.Deck
import blackjack.domain.Player

class GamePlayView {
    companion object {
        @JvmStatic
        fun playTurnsForAll(
            players: List<Player>,
            deck: Deck,
        ) {
            for (player in players) {
                playTurnsForSingle(player, deck)
            }
        }

        @JvmStatic
        fun playTurnsForSingle(
            player: Player,
            deck: Deck,
        ) {
            while (isPlay(player)) {
                playTurn(player, deck)
            }
        }

        @JvmStatic
        private fun isPlay(player: Player): Boolean {
            val canReceive = player.canReceiveCard()
            if (!canReceive) {
                return false
            }

            println("${player.name} 는 한장의 카드를 더 받겠습니까? (예 : y, 아니오 : n)")
            val choice: String = readLine() ?: ""
            return choice.equals("y")
        }

        @JvmStatic
        private fun playTurn(
            player: Player,
            deck: Deck,
        ): Boolean {
            player.receiveCard(deck.drawCard())
            val cards = player.getCardNames().joinToString(",")
            println("${player.name} : $cards")

            return true
        }
    }
}
