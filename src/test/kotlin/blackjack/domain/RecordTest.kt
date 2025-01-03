package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RecordTest {
    @Test
    fun `test_calculate_본인과 상대가 21 초과하면 드로우`() {
        val origin = Score.from(22)
        val other = Score.from(23)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(0, 0, 1))
    }

    @Test
    fun `test_calculate_본인만 21 초과하면 본인 패배`() {
        val origin = Score.from(22)
        val other = Score.from(1)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(0, 1, 0))
    }

    @Test
    fun `test_calculate_상대만 21 초과하면 본인 승리`() {
        val origin = Score.from(2)
        val other = Score.from(22)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(1, 0, 0))
    }

    @Test
    fun `test_calculate_본인과 상대가 21을 넘지 않고 같은 숫자면 드로우`() {
        val origin = Score.from(11)
        val other = Score.from(11)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(0, 0, 1))
    }

    @Test
    fun `test_calculate_본인과 상대가 21을 넘지 않고, 본인이 21에 더 가까우면 본인 승리`() {
        val origin = Score.from(3)
        val other = Score.from(1)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(1, 0, 0))
    }

    @Test
    fun `test_calculate_본인과 상대가 21을 넘지 않고, 상대가 21에 더 가까우면 본인 패배`() {
        val origin = Score.from(1)
        val other = Score.from(11)
        val record = Record()
        assertTrue(record.calculate(origin, other) == Record(0, 1, 0))
    }

    @Test
    fun `test_getRecord_값이 없으면 미표시_1`() {
        val record1 = Record(0, 1, 0)
        assertThat(record1.getRecord()).isEqualTo("1패")

        val record2 = Record(1, 1, 0)
        assertThat(record2.getRecord()).isEqualTo("1승 1패")

        val record3 = Record(1, 1, 1)
        assertThat(record3.getRecord()).isEqualTo("1승 1무 1패")
    }

    @Test
    fun name() {
        val record = Record(0, 0, 0)
    }
}
