import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

import com.example.Example

class ExampleSpec extends JenkinsPipelineSpecification {
    def example = null

    def setup() {
        example = new Example()

        explicitlyMockPipelineVariable("out")
    }

    def "[GetAllRuns] will get all runs" () {
        when:
            example.execute()
        then:
            1 * getPipelineMock("sh")("command")
    }
}
