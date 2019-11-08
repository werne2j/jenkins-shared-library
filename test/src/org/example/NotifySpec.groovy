import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import org.example.Constants
import org.example.Notify

class NotifySpec extends JenkinsPipelineSpecification {
    def notifyClass = null

    def setup() {
        notifyClass = new Notify()
    }

    def "[notify] will echo SLACK_MESSAGE if type is slack"() {
        when:
            notifyClass.exec(type: "slack")
        then:
            1 * getPipelineMock("echo")(Constants.SLACK_MESSAGE)
    }

    def "[notify] will echo EMAIL_MESSAGE if no type passed"() {
        when:
            notifyClass.exec()
        then:
            1 * getPipelineMock("echo")(Constants.EMAIL_MESSAGE)
    }
}
