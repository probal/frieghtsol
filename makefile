all:
	sudo pkill -f 'java'
	git pull
	npm run --prefix src/main/resources/static/client build
	mvn clean install
	sudo java -XX:-UseLoopPredicate -jar target/freightsol-1.0.jar


local:
	npm run --prefix src/main/resources/static/client build
	mvn clean install
	java -jar target/freightsol-1.0.jar > output.log