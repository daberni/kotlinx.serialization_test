import kotlinx.serialization.Mapper
import kotlinx.serialization.Serializable
import org.junit.Assert
import org.junit.Test


@Serializable
class NullablePropertyClass {

    var nullable: String? = null
    var property: String = "Property Value"
}

class NullablePropertyClassTest {

    @Test
    fun testNullableNotNullProperty() {

        val derived = NullablePropertyClass().apply {
            nullable = "not null"
        }

        val map = Mapper.map(derived)
        val unmap = Mapper.unmap<NullablePropertyClass>(map)

        Assert.assertEquals(derived.nullable, unmap.nullable)
        Assert.assertEquals(derived.property, unmap.property)
    }

    @Test
    fun testNullableNullProperty() {

        val derived = NullablePropertyClass()

        val map = Mapper.map(derived)
        val unmap = Mapper.unmap<NullablePropertyClass>(map)

        Assert.assertEquals(derived.nullable, unmap.nullable)
        Assert.assertEquals(derived.property, unmap.property)
    }

}
