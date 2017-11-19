all:
	sudo pkill -f 'java'
	git pull
	npm run --prefix client-dev build
	rm -rf src/main/resources/static/client/*
	cp -rf client-dev/dist/* src/main/resources/static/
	mvn clean install
	sudo java -XX:-UseLoopPredicate -jar target/freightsol-1.0.jar


local:
	mvn clean install
	java -jar target/freightsol-1.0.jar > output.log


clientdev:
	npm run --prefix client dev