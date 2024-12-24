package blackjack.view

import blackjack.domain.Dealer
import blackjack.domain.Player

class GameBoardView {
    companion object {
        @JvmStatic
        fun play(
            player: Player,
            dealer: Dealer,
        ) {
            while (isPlay(player)) {
                playTurn(player, dealer)
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
            dealer: Dealer,
        ): Boolean {
            player.receiveCard(dealer.drawCard())
            val cards = player.getCardNames().joinToString(",")
            println("${player.name} : $cards")

            return true
        }
    }
}
