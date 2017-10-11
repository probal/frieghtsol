all:
	sudo pkill -f 'java'
	git pull
	mvn clean install
	sudo java -XX:-UseLoopPredicate -jar target/freightsol-1.0.jar


local:
	mvn clean install
	java -jar target/freightsol-1.0.jar > output.log