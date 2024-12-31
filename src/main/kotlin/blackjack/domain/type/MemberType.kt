package blackjack.domain.type

enum class MemberType (val member: String, val drawable: Int) {
    DEALER("딜러", 17), PLAYER("플레이어", 21), NONE("", -1)
}