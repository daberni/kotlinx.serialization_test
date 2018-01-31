import kotlinx.serialization.Mapper
import kotlinx.serialization.json.JSON
import org.junit.Assert
import org.junit.Test

class SampleTest {

    @Test
    fun someTest() {

        val data = SomeDataClass("xy", "z")

        val map = Mapper.map(data)

        Assert.assertEquals("xy", map["x"])
        Assert.assertEquals("z", map["y"])
    }

    @Test
    fun otherTest() {

        val map = mapOf(
                "x" to "some other stuff"
        )

        val data = Mapper.unmap<SomeDataClass>(map)

        Assert.assertEquals("some other stuff", data.x)
        Assert.assertEquals("Class", data.y)
    }

    @Test
    fun jsonParseTest() {

        val json = """
            {
                "x": "some other stuff"
            }
        """

        val data = JSON.parse<SomeDataClass>(json)

        Assert.assertEquals("some other stuff", data.x)
        Assert.assertEquals("Class", data.y)
    }
}
