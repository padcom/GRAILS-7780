import org.apache.camel.Exchange

class ExampleService {
	static transactional = false

	void stepOne(Exchange exchange) {
		Person.withNewSession { session ->
			def p = new Person(firstName: exchange.in.getHeader("firstName"), lastName: exchange.in.getHeader("lastName"))
			p.save(flush: true)
		}
	}

	void stepTwo(Exchange exchange) {
		Person.withNewSession { session ->
			def p = new Person(firstName: exchange.in.getHeader("firstName"), lastName: exchange.in.getHeader("lastName"))
			p.firstName = "Step2: ${p.firstName}"
			p.lastName = "Step2: ${p.lastName}"
			p.save(flush: true)
		}
	}
}
