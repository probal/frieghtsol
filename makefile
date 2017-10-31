all:
	sudo pkill -f 'java'
	git pull
	npm run --prefix client build
	rm -rf src/main/resources/static/client/*
	cp -rf client/dist/* src/main/resources/static/client
	mvn clean install
	sudo java -XX:-UseLoopPredicate -jar target/freightsol-1.0.jar


local:
	mvn clean install
	java -jar target/freightsol-1.0.jar > output.log


clientdev:
	npm run --prefix client dev