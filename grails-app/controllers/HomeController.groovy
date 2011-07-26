class HomeController {
	def index = {
		sendMessageAndHeaders("activemq:example.input", "Hello", [ firstName: "_John_", lastName: "_Doe_" ])
		render text: "OK", contentType: "text/plain"
	}
}
