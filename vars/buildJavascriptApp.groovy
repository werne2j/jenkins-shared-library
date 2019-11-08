import org.example.BuildJavascriptApp

def call(Map config=[:], Closure body={}) {
    def buildJavascriptApp = new BuildJavascriptApp()
    buildJavascriptApp.exec(config, body)
}
