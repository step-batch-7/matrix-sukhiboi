mkdir lib;
cd lib

printf "Installing hamcrest-core1.3.jar..."
curl -Ls https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar --output hamcrest-core-1.3.jar
printf "Done\n"

printf "Installing junit-4.13.1..."
curl -Ls https://search.maven.org/remotecontent\?filepath\=junit/junit/4.13.1/junit-4.13.1.jar --output junit-4.13.1.jar
printf "Done\n"