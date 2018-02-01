import kotlinx.serialization.Mapper
import kotlinx.serialization.json.JSON
import org.junit.Assert
import org.junit.Test

class PropertyListOrderTest {

    @Test
    fun propertyListOrderTest() {

        val listOrder = WrongPropertyListOrderClass().apply {
            someList = listOf("listElement1", "listElement2")
        }

        val json = JSON.stringify(listOrder)

        Assert.assertEquals(true, json.contains(""""someList":"""))
        Assert.assertEquals(true, json.contains(""""someProperty":"""))

        val map = Mapper.map(listOrder)
        val unmap = Mapper.unmap<WrongPropertyListOrderClass>(map)

        Assert.assertEquals(listOrder.someProperty, unmap.someProperty)
        Assert.assertEquals(listOrder.someList, unmap.someList)
    }

    @Test
    fun correctPropertyListOrderTest() {

        val listOrder = CorrectPropertyListOrderClass().apply {
            someList = listOf("listElement1", "listElement2")
        }

        val json = JSON.stringify(listOrder)

        Assert.assertEquals(true, json.contains(""""someList":"""))
        Assert.assertEquals(true, json.contains(""""someProperty":"""))

        val map = Mapper.map(listOrder)
        val unmap = Mapper.unmap<CorrectPropertyListOrderClass>(map)

        Assert.assertEquals(listOrder.someProperty, unmap.someProperty)
        Assert.assertEquals(listOrder.someList, unmap.someList)
    }
}
