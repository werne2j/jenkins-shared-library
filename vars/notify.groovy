import org.example.Notify

def call(Map config=[:]) {
    def notify = new Notify()
    notify.exec(config)
}
