printf "Compiling...";
rm -rf out;
mkdir out;
javac -d out -cp $(find lib -name '*.jar' | tr '\n' ':').:test $(find . -name '*.java');printf "Done\n";