package org.example

class Notify {
    def exec(Map config=[:]) {
        def type = config.type
        if (type == "slack") {
            echo Constants.SLACK_MESSAGE
            echo config.message
        } else {
            echo Constants.EMAIL_MESSAGE
            echo config.message
        }
    }
}
