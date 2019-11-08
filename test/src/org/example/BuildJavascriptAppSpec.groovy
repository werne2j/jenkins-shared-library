import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import org.example.BuildJavascriptApp

class BuildJavascriptAppSpec extends JenkinsPipelineSpecification {
    def buildJavascriptApp = null

    def setup() {
        buildJavascriptApp = new BuildJavascriptApp()
    }

    def "[buildJavascriptApp] will run npm publish if deploy is true"() {
        when:
            buildJavascriptApp.exec(deploy: true)
        then:
            1 * getPipelineMock("sh")("npm publish")
    }

    def "[buildJavascriptApp] will not npm publish if deploy is false"() {
        when:
            buildJavascriptApp.exec(deploy: false)
        then:
            0 * getPipelineMock("sh")("npm publish")
    }

    def "[buildJavascriptApp] will call closure if passed"() {
        setup:
            def body = Mock(Closure)
        when:
            buildJavascriptApp.exec(deploy: false, body)
        then:
            1 * body()
    }
}
