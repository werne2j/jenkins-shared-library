import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import com.example.Example

class ExampleSpec extends JenkinsPipelineSpecification {
  def example = null

  def setup() {
    example = new Example()
    explicitlyMockPipelineVariable("out")
  }

  def "[ExampleSpec] will execute" () {
    when:
      example.execute()
    then:
      1 * getPipelineMock("sh")("command")
  }

  def "[ExampleSpec] will not execute" () {
    when:
      def output = example.execute(false)
    then:
      0 * getPipelineMock("sh")(_)
    expect:
      output == "Should not execute"
  }
}
