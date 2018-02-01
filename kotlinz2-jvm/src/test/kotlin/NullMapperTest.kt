import kotlinx.serialization.Mapper
import org.junit.Assert
import org.junit.Test

class NullMapperTest {

    @Test
    fun testNullableNotNullProperty() {

        val derived = Derived().apply {
            nullable = "not null"
        }

        val map = Mapper.map(derived)
        val unmap = Mapper.unmap<Derived>(map)

        Assert.assertEquals(derived.nullable, unmap.nullable)
        Assert.assertEquals(derived.property, unmap.property)
    }

    @Test
    fun testNullableNullProperty() {

        val derived = Derived()

        val map = Mapper.map(derived)
        val unmap = Mapper.unmap<Derived>(map)

        Assert.assertEquals(derived.nullable, unmap.nullable)
        Assert.assertEquals(derived.property, unmap.property)
    }
}
