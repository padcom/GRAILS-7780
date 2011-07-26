class HomeController {
	def index = {
		Thread.start {
			Person.withNewSession { session ->
				new Person(firstName: "John", lastName: "Doe").save(flush: true)
			}
			Person.withNewSession { session ->
				new Person(firstName: "Jane", lastName: "Smith").save(flush: true)
			}
		}
		render text: "OK", contentType: "text/plain"
	}
}
