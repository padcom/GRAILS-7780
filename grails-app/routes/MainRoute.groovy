class MainRoute {
	def configure = {
		from('activemq:example.input').to('bean:exampleService?method=stepOne').to('bean:exampleService?method=stepTwo')
	}
}
