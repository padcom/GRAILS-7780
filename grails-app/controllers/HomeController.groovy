class HomeController {
	def index = {
		Thread.start {
			Person.withNewSession { session ->
				new Person(firstName: "a", lastName: "b").save(flush: true)
			}
			Person.withNewSession { session ->
				new Person(firstName: "c", lastName: "d").save(flush: true)
			}
		}
		render text: "OK", contentType: "text/plain"
	}
}
