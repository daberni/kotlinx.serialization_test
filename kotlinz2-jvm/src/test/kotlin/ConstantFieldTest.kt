import kotlinx.serialization.Mapper
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.junit.Assert
import org.junit.Test

@Serializable
abstract class AbstractConstantField {

    abstract val type: String
    var superVariable = "super text"
}

@Serializable
class ConstantField : AbstractConstantField() {

    override val type: String = "Constant"
    var variable: String? = "some text"
}

class ConstantFieldTest {

    @Test
    fun constantFieldTest() {

        val constantField = ConstantField()

        val json = JSON.stringify(constantField)

        Assert.assertEquals(true, json.contains(""""type":"Constant""""))

        val map = Mapper.map(constantField)
        val unmap = Mapper.unmap<ConstantField>(map)

        Assert.assertEquals(constantField.type, unmap.type)
        Assert.assertEquals(constantField.variable, unmap.variable)
        Assert.assertEquals(constantField.superVariable, unmap.superVariable)
    }
}
