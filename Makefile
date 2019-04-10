setupDocker:
	docker build --no-cache -t jaskirattestmoviedb:1.0 -f ./Dockerfile .

test_docker:	setupDocker
	docker run -it --rm jaskirattestmoviedb:1.0 mvn test

test_local:
	mvn test
