class HomeController {
	def index = {
		Thread.start {
//			println "First 'withNewSession call'"
			Person.withNewSession { session ->
				new Person(firstName: "John", lastName: "Doe").save(flush: true)
			}
//			println "Second 'withNewSession call'"
			Person.withNewSession { session ->
				new Person(firstName: "Jane", lastName: "Smith").save(flush: true)
			}
		}
		render text: "OK", contentType: "text/plain"
	}
}
