import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import org.example.Constants

class NotifySpec extends JenkinsPipelineSpecification {
    def notifyVar = null

    def setup() {
        notifyVar = loadPipelineScriptForTest("vars/notify.groovy")
    }

    def "[notify] will echo SLACK_MESSAGE if type is slack"() {
        when:
            notifyVar type: "slack"
        then:
            1 * getPipelineMock("echo")(Constants.SLACK_MESSAGE)
    }

    def "[notify] will echo EMAIL_MESSAGE if no type passed"() {
        when:
            notifyVar()
        then:
            1 * getPipelineMock("echo")(Constants.EMAIL_MESSAGE)
    }
}
